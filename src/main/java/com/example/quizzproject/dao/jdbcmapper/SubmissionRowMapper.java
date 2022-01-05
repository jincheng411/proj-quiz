package com.example.quizzproject.dao.jdbcmapper;

import com.example.quizzproject.entity.Submission;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubmissionRowMapper implements RowMapper<Submission> {
    @Override
    public Submission mapRow(ResultSet rs, int i) throws SQLException {
        Submission sub = new Submission();
        sub.setId(rs.getInt("id"));
        sub.setEndTime(rs.getTimestamp("end_time"));
        sub.setIsPassed(rs.getInt("is_passed"));
        sub.setQuizTypeId(rs.getInt("quiz_type_id"));
        sub.setUserId(rs.getInt("user_id"));
        sub.setStartTime(rs.getTimestamp("start_time"));
        return sub;
    }
}
