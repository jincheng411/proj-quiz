package com.example.quizzproject.runner;

import com.example.quizzproject.dao.SubmissionDao;
import com.example.quizzproject.dao.UserDao;
import com.example.quizzproject.entity.Report;
import com.example.quizzproject.entity.Submission;
import com.example.quizzproject.entity.User;
import com.example.quizzproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    public ReportService reportService;

    @Autowired
    public SubmissionService submissionService;

    @Autowired
    public SubmissionDao submissionDao;
    @Override
    public void run(String... args) throws Exception{
//        System.out.println(questionService.getQuestionById(1));
//        System.out.println(questionService.getChoiceByQuestion(1));
//        User user = userDao.getUserByEmail("sw02102@gmail.com");
//        User user = userDao.getUserByEmail("sw02102@gmail.com");
//        System.out.println(user);
//        Submission sub = new Submission();
//        sub.setStartTime(new Timestamp(System.currentTimeMillis()));
//        sub.setUserId(1);
//        sub.setQuizTypeId(1);
//        sub.setIsPassed(null);
//        sub.setStartTime(new Timestamp(System.currentTimeMillis()));
//        submissionService.createSubmission(sub);
//        submissionService.updateSubmissionResult(2, 1, new Timestamp(System.currentTimeMillis()));
//        userService.getUserByEmail("sw02102@gmail.com");
//       User user = userService.getUserById(1);
//        System.out.println(user);
//        System.out.println(quizTypeService.getAllQuizType());
//        Report r = new Report();
//        r.setSelectId(1);
//        r.setQuestionId(1);
//        r.setAnswerId(1);
//        r.setSubmissionId(2);
//        reportService.createReport(r);
//        System.out.println(submissionService.findSubmissionById(2));
//        System.out.println(submissionDao.findSubmissionById(2));
//        System.out.println(reportService.getReportBySubmissionId(122));
    }

}
