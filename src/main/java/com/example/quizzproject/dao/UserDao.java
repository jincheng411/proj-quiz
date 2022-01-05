package com.example.quizzproject.dao;

import com.example.quizzproject.entity.User;

public interface UserDao {
    User getUserById(int id);
    User getUserByEmail(String email);
    int createUser(User user);
}
