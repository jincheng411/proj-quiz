package com.example.quizzproject.dao.impl;

import com.example.quizzproject.dao.ReportDao;
import com.example.quizzproject.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportJdbcDaoImpl implements ReportDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final static String CREATE_REPORT =
            "INSERT INTO report (submission_id, question_id, select_id, answer_id) " +
                    "VALUES (?, ?, ?, ?)";
    private final static String GET_REPORT_BY_SUBMISSION_ID =
            "SELECT * FROM report r JOIN submission s ON s.id = r.submission_id WHERE s.id = ?";
    @Override
    public int createReport(Report report) {
        return jdbcTemplate.update(CREATE_REPORT,
                report.getSubmissionId(),
                report.getQuestionId(),
                report.getSelectId(),
                report.getAnswerId());
    }

    @Override
    public List<Report> getReportBySubmissionId(int sId) {
        return jdbcTemplate.query(GET_REPORT_BY_SUBMISSION_ID, new BeanPropertyRowMapper<>(Report.class), sId);
    }
}
