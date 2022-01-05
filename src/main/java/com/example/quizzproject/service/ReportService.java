package com.example.quizzproject.service;

import com.example.quizzproject.dao.ReportDao;
import com.example.quizzproject.entity.Choice;
import com.example.quizzproject.entity.Question;
import com.example.quizzproject.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;
    @Autowired
    QuestionService questionService;

    @Transactional
    public int createReport(Report report) {
        return reportDao.createReport(report);
    }

    @Transactional
    public void createAllReports(Collection<Report> reports) {
        for(Report r: reports) {
            reportDao.createReport(r);
        }
    }

    @Transactional
    public Map<Integer, Report> getReportBySubmissionId(int sId) {
        List<Report> reportList = reportDao.getReportBySubmissionId(sId);
        Map<Integer, Report> reportMap = new HashMap<>();
        for (Report r : reportList) {
            reportMap.put(r.getQuestionId(), r);
        }
        return reportMap;
    }
    @Transactional
    public Map<Integer, Report> generateAllReportsInQuestionList(List<Question> questions, int sId) {
        Map<Integer, Report> map = new HashMap<>();
        for (int i = 0; i < questions.size(); i++) {
            Report r = new Report();
            int qId = questions.get(i).getId();
            r.setQuestionId(qId);
            r.setSubmissionId(sId);
            List<Choice> choices = questionService.getChoiceByQuestion(qId);
            for (Choice c : choices) {
                if (c.getIsAnswer() == 1) {
                    r.setAnswerId(c.getId());
                }
            }
            map.put(i, r);
        }
        return map;
    }

    public int getNumOfCorrectAnswer(int sId) {
        int count = 0;
        List<Report> reportList = reportDao.getReportBySubmissionId(sId);
        for (Report r : reportList) {
            if (r.getAnswerId() == r.getSelectId()) count++;
        }
        return count;
    }

    public int getQuizResult(Collection<Report> reports) {
        int count = 0;
        for(Report r: reports) {
            if (r.getSelectId() == r.getAnswerId()) {
                count++;
            }
        }
        if (count >= 6) {
            return 1;
        } else {
            return 0;
        }
    }
}
