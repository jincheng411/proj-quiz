package com.example.quizzproject.dao.jdbcmapper;

import com.example.quizzproject.entity.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int i) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setDescription(rs.getString("description"));
        question.setQuizTypeId(rs.getInt("quiz_type_id"));
        return question;
    }
}
