package com.example.quizzproject.dao.jdbcmapper;

import com.example.quizzproject.entity.Choice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoiceRowMapper implements RowMapper<Choice> {
    @Override
    public Choice mapRow(ResultSet rs, int i) throws SQLException {
        Choice choice = new Choice();
        choice.setId(rs.getInt("id"));
        choice.setDescription(rs.getString("description"));
        choice.setIsAnswer(rs.getInt("is_answer"));
        return choice;
    }
}
