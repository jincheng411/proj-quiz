package com.example.quizzproject.dao.impl;

import com.example.quizzproject.dao.SubmissionDao;
import com.example.quizzproject.entity.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class SubmissionJdbcDaoImpl implements SubmissionDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final static String UPDATE_SUBMISSION =
            "UPDATE submission SET is_passed=?, end_time=? WHERE id=?";
    private final static String UPDATE_SUBMISSION_START_TIME =
            "UPDATE submission SET start_time=? WHERE id=?";
    private final static String GET_SUBMISSION_BY_ID =
            "SELECT * FROM submission WHERE id=?";

    private final static String GET_SUBMISSION_BY_USER_ID =
            "SELECT * FROM submission WHERE user_id=?";
    @Override
    public int createSubmission(Submission submission) {
        String CREATE_SUBMISSION =
                String.format("INSERT INTO submission (user_id, quiz_type_id) " +
                        "VALUES (%1$s, %2$s)",
                        submission.getUserId().toString(),
                        submission.getQuizTypeId().toString());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(CREATE_SUBMISSION,
                    Statement.RETURN_GENERATED_KEYS);
            return ps;
        },keyHolder);
        return keyHolder.getKey().intValue();
    }
    public int updateSubmissionStartTime(int sId, Timestamp startTime) {
        return jdbcTemplate.update(UPDATE_SUBMISSION_START_TIME, startTime, sId);
    }

    public int updateSubmissionResult(int sId, int isPassed, Timestamp endTime){
        return jdbcTemplate.update(UPDATE_SUBMISSION, isPassed, endTime, sId);
    }

    public Submission findSubmissionById(int id) {
        return jdbcTemplate.queryForObject(GET_SUBMISSION_BY_ID, new BeanPropertyRowMapper<>(Submission.class), id);
    }

    public List<Submission> findSubmissionByUserId(int id) {
        return jdbcTemplate.query(GET_SUBMISSION_BY_USER_ID, new BeanPropertyRowMapper<>(Submission.class), id);
    }
}
