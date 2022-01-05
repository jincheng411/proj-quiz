package com.example.quizzproject.dao.impl;

import com.example.quizzproject.dao.ChoiceDao;
import com.example.quizzproject.entity.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceJdbcDaoImpl implements ChoiceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final static String GET_CHOICE_BY_QUESTION
            = "SELECT c.id, c.question_id, c.description, c.is_answer " +
            "FROM choice c JOIN question q ON c.question_id = q.id " +
            "WHERE q.id = ?";

    public List<Choice> getChoiceByQuestion(int questionId){
        return jdbcTemplate.query(GET_CHOICE_BY_QUESTION, new BeanPropertyRowMapper<>(Choice.class), questionId);
    }
}
