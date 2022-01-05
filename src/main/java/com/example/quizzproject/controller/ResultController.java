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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class ResultController {
    private SubmissionService submissionService;
    private QuestionService questionService;
    private ReportService reportService;
    private QuizTypeService quizTypeService;

    @Autowired
    public ResultController(SubmissionService submissionService,
                            QuestionService questionService,
                            ReportService reportService,
                            QuizTypeService quizTypeService
    ) {
        this.submissionService = submissionService;
        this.questionService = questionService;
        this.reportService = reportService;
        this.quizTypeService = quizTypeService;
    }

    @GetMapping("/result/{sId}")
    public String getResult(Model model, @PathVariable Integer sId, HttpServletRequest req) {

        //check authentication
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User)session.getAttribute("user");
        session.invalidate();
        HttpSession newSession = req.getSession(true);
        newSession.setAttribute("user", user);
        newSession.setMaxInactiveInterval(300);

        Submission submission = submissionService.findSubmissionById(sId);
        model.addAttribute("submission", submission);
        List<Question> questions = questionService.getQuestionBySubmissionId(sId);
        model.addAttribute("questions", questions);
        Map<Integer, List<Choice>> choiceList = questionService.getAllChoicesByQuestionList(questions);
        model.addAttribute("choiceList", choiceList);
        char[] arr = new char[]{'A', 'B', 'C', 'D'};
        model.addAttribute("arr", arr);
        Map<Integer, Report> reportSet = reportService.getReportBySubmissionId(sId);
        model.addAttribute("reportSet", reportSet);
        int correctionCount = reportService.getNumOfCorrectAnswer(sId);
        model.addAttribute("correctCount", correctionCount);
        return "result";
    }

    @GetMapping("/result")
    public String allResult(Model model, HttpServletRequest req) {

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

        List<Submission> submissions = submissionService.findSubmissionByUserId(user.getId());
        model.addAttribute("submissions", submissions);

        String[] quizTypes = new String[]{"quiz","Java core", "My SQL", "JavaScript"};
        model.addAttribute("quizTypes", quizTypes);

        return "history";
    }

    @GetMapping("/feedback")
    public String feedbackGet(Model model) {
        List<QuizType> quizTypes = quizTypeService.getAllQuizType();
        model.addAttribute("quizTypes", quizTypes);
        return "feedback";
    }
}
