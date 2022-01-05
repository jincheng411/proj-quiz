package com.example.quizzproject.dao.impl;

import com.example.quizzproject.dao.QuestionDao;
import com.example.quizzproject.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionJdbcDaoImpl implements QuestionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String GET_QUESTION_BY_ID = "SELECT * FROM question WHERE id=?";
    private final static String GET_QUESTION_BY_QUIZ_TYPE =
            "SELECT qa.id, qa.description, qa.quiz_type_id FROM question qa " +
            "JOIN quiz_type qz " +
            "ON qa.quiz_type_id=qz.id " +
            "WHERE qz.id=? ORDER BY RAND() LIMIT 10";
    private final static String GET_QUESTION_BY_SUBMISSION_ID =
            "SELECT q.id, q.description, q.quiz_type_id\n" +
            "FROM question q\n" +
            "JOIN (report r, submission s)\n" +
            "ON(s.id = r.submission_id AND r.question_id = q.id)\n" +
            "WHERE s.id = ?";
    @Override
    public List<Question> getQuestionByQuizType(int quizTypeId){
        return jdbcTemplate.query(GET_QUESTION_BY_QUIZ_TYPE, new BeanPropertyRowMapper<>(Question.class), quizTypeId);
    }

    @Override
    public Question getQuestionById(int id) {
        return jdbcTemplate.queryForObject(GET_QUESTION_BY_ID, new BeanPropertyRowMapper<>(Question.class), id);

    }

    @Override
    public List<Question> getQuestionBySubmissionId(int sId) {
        return jdbcTemplate.query(GET_QUESTION_BY_SUBMISSION_ID, new BeanPropertyRowMapper<>(Question.class), sId);
    }
}
