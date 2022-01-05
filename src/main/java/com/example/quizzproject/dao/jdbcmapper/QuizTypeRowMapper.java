package com.example.quizzproject.dao.jdbcmapper;

import com.example.quizzproject.entity.QuizType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizTypeRowMapper implements RowMapper<QuizType> {
    @Override
    public QuizType mapRow(ResultSet rs, int i) throws SQLException {
        QuizType quizType = new QuizType();
        quizType.setId(rs.getInt("id"));
        quizType.setName(rs.getString("name"));
        quizType.setDifficulty(rs.getInt("difficulty"));
        quizType.setDifficulty(rs.getInt("timeLimit"));
        quizType.setImage(rs.getString("image"));
        quizType.setDescription(rs.getString("description"));
        return quizType;
    }
}
