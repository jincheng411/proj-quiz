package com.example.quizzproject.dao;


import com.example.quizzproject.entity.Submission;

import java.sql.Timestamp;
import java.util.List;

public interface SubmissionDao {
    int createSubmission(Submission submission);
    int updateSubmissionResult(int sId, int isPassed, Timestamp endTime);
    int updateSubmissionStartTime(int sId, Timestamp startTime);
    Submission findSubmissionById(int id);
    List<Submission> findSubmissionByUserId(int id);
}
