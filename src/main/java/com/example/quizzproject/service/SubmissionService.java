package com.example.quizzproject.service;

import com.example.quizzproject.dao.SubmissionDao;
import com.example.quizzproject.entity.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionDao submissionDao;

    @Transactional
    public int createSubmission(Submission submission) {
        return submissionDao.createSubmission(submission);
    }

    @Transactional
    public int updateSubmissionResult(int sId, int isPassed, Timestamp endTime) {
        return submissionDao.updateSubmissionResult(sId, isPassed, endTime);
    }

    @Transactional
    public int updateSubmissionStartTime(int sId, Timestamp startTime) {
        return submissionDao.updateSubmissionStartTime(sId, startTime);
    }

    @Transactional
    public List<Submission> findSubmissionByUserId(int id) {
        return submissionDao.findSubmissionByUserId(id);
    }

    public Submission findSubmissionById(int id) {
        return submissionDao.findSubmissionById(id);
    }
}
