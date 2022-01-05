package com.example.quizzproject.controller;

import com.example.quizzproject.entity.*;
import com.example.quizzproject.service.QuestionService;
import com.example.quizzproject.service.QuizTypeService;
import com.example.quizzproject.service.ReportService;
import com.example.quizzproject.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@SessionAttributes({"quizId", "timer", "questionId", "question", "submission", "reports", "questions", "currIndex", "choices", "answered"})
@Controller
public class QuizController {
    public QuizTypeService quizTypeService;
    public QuestionService questionService;
    public SubmissionService submissionService;
    public ReportService reportService;

    @Autowired
    public QuizController(QuizTypeService quizTypeService,
                          QuestionService questionService,
                          SubmissionService submissionService,
                          ReportService reportService) {
        this.quizTypeService = quizTypeService;
        this.questionService = questionService;
        this.submissionService = submissionService;
        this.reportService = reportService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<QuizType> quiz = quizTypeService.getAllQuizType();
        model.addAttribute("quiz", quiz);
        return "index";
    }

    @GetMapping("/quiz/{id}")
    public String quizHome(Model model,
                           HttpServletRequest req,
                           @PathVariable int id,
                           @RequestParam(required = false) Integer newQuiz,
                           @RequestParam(required = false) Integer index
    ) {

        //check if login
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User)session.getAttribute("user");
        session.invalidate();
        HttpSession newSession = req.getSession(true);
        newSession.setAttribute("user", user);
        newSession.setMaxInactiveInterval(300);

        model.addAttribute("quizId", id);
        int currIndex;
        Map<Integer, Report> reports;
        //question
        if (newQuiz != null) { //new quiz
            currIndex = 0;
            model.addAttribute("currIndex", currIndex);

            List<Question> questions = questionService.getQuestionByQuizType(id);
            model.addAttribute("questions", questions);

            //create new submission if never been created
            Submission sub = new Submission();
            sub.setQuizTypeId(id);

            sub.setUserId(user.getId());
            sub.setStartTime(new Timestamp(System.currentTimeMillis()));
            sub.setId(submissionService.createSubmission(sub));
            submissionService.updateSubmissionStartTime(sub.getId(),new Timestamp(System.currentTimeMillis()));
            model.addAttribute("submission", sub);

            //create report list
            reports = reportService.generateAllReportsInQuestionList(questions, sub.getId());
            model.addAttribute("reports", reports);

            //timer 30min
            String timer = new Date(System.currentTimeMillis() + 10 * 1000).toString();
            model.addAttribute("timer", timer);

            //answered
            Set<Integer> answered = new HashSet<>();
            model.addAttribute("answered", answered);
        } else {
            reports =(Map<Integer, Report>)model.getAttribute("reports");
            if (index == null) {
            currIndex = (Integer)model.getAttribute("currIndex");
            } else {
                currIndex = index;
                model.addAttribute("currIndex", currIndex);
            }
        }
        //get question list
        List<Question> questions = (List<Question>) model.getAttribute("questions");
        int questionId = questions.get(currIndex).getId();
        //get current question
        Question question = questions.get(currIndex);
        model.addAttribute("question", question);

        //report
        Report report = reports.get(currIndex);
        if (report != null) {
            model.addAttribute("answerId", report.getSelectId());
        }

//        choices
        List<Choice> choices = questionService.getChoiceByQuestion(questionId);
        model.addAttribute("choices", choices);
        model.addAttribute("questionId", questionId);


        return "quizHome";
    }
}
