package com.example.quizzproject.dao.jdbcmapper;

import com.example.quizzproject.entity.Report;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRowMapper implements RowMapper<Report> {
    @Override
    public Report mapRow(ResultSet rs, int i) throws SQLException {
        Report report = new Report();
        report.setId(rs.getInt("id"));
        report.setAnswerId(rs.getInt("answer_id"));
        report.setQuestionId(rs.getInt("question_id"));
        report.setSelectId(rs.getInt("select_id"));

        return report;
    }
}
