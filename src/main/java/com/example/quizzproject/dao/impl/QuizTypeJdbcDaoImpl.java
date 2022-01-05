package com.example.quizzproject.dao.impl;

import com.example.quizzproject.dao.QuizTypeDao;
import com.example.quizzproject.entity.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class QuizTypeJdbcDaoImpl implements QuizTypeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_QUIZ_TYPE = "SELECT * FROM quiz_type";

    public List<QuizType> getAllQuizType() {
        return jdbcTemplate.query(GET_ALL_QUIZ_TYPE, new BeanPropertyRowMapper<>(QuizType.class));
    }
}
