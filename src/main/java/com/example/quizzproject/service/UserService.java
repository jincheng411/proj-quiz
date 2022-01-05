package com.example.quizzproject.service;

import com.example.quizzproject.dao.UserDao;
import com.example.quizzproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public int createUser(String name, String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return userDao.createUser(user);
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Transactional
    public boolean authenticateUser(String email, String password) {
        if (email == null || password == null) return false;
        User user = userDao.getUserByEmail(email);
        if (user == null) return false;
        return user.getPassword().equals(password);
    }
}
