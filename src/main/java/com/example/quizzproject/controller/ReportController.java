package com.example.quizzproject.controller;
import com.example.quizzproject.entity.Choice;
import com.example.quizzproject.entity.Question;
import com.example.quizzproject.entity.Report;
import com.example.quizzproject.entity.Submission;
import com.example.quizzproject.service.ReportService;
import com.example.quizzproject.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SessionAttributes({"quizId", "submission", "reports", "questions", "currIndex", "question", "choices", "answered"})
@Controller
public class ReportController {
    private ReportService reportService;
    private SubmissionService submissionService;

    @Autowired
    public ReportController(ReportService reportService,
                            SubmissionService submissionService
    ) {
        this.reportService = reportService;
        this.submissionService = submissionService;
    }

    @PostMapping("/report")
    public String createReport(Model model, @RequestParam(required = false) Integer input, @RequestParam(required = false) String action) {
        int quizId = (Integer) model.getAttribute("quizId");
        int index = (Integer) model.getAttribute("currIndex");
        Submission submission = (Submission) model.getAttribute("submission");
        Question question = (Question) model.getAttribute("question");
        List<Choice> choices = (List<Choice>) model.getAttribute("choices");
        Map<Integer, Report> reports = (Map<Integer, Report>) model.getAttribute("reports");

        //create report if have not
        Report report = reports.get(index);

        report.setSelectId(input);
        Set<Integer> answered = (Set<Integer>) model.getAttribute("answered");

        if (input != null) {
            answered.add(index);
        }

        if (action.equals("next") && index < 9) {
            model.addAttribute("currIndex", index + 1);
        } else if (action.equals("prev") && index > 0) {
            model.addAttribute("currIndex", index - 1);
        } else if (action.equals("submit")) {
            reportService.createAllReports(reports.values());
            int isPass = reportService.getQuizResult(reports.values());
            submission.setIsPassed(isPass);
            submissionService.updateSubmissionResult(submission.getId(), isPass, new Timestamp(System.currentTimeMillis()));
            return "redirect:/result/" + submission.getId();
        }
        return "redirect:/quiz/" + quizId;
    }
}
