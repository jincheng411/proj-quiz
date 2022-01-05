package com.example.quizzproject.dao;

import com.example.quizzproject.entity.Report;

import java.util.List;

public interface ReportDao {
    int createReport(Report report);
    List<Report> getReportBySubmissionId(int sId);
}
