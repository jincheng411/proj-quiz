package com.example.quizzproject.dao.impl;

import com.example.quizzproject.dao.UserDao;
import com.example.quizzproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email=?";
    private static final String CREATE_USER = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

    public int createUser(User user) {
        return jdbcTemplate.update(CREATE_USER, user.getName(), user.getEmail(), user.getPassword());
    }

    public User getUserById(int id) {
        try {
        User user = jdbcTemplate.queryForObject(GET_USER_BY_ID, new BeanPropertyRowMapper<>(User.class), id);
        return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User getUserByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new BeanPropertyRowMapper<>(User.class), email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
