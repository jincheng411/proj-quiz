package com.example.quizzproject.service;

import com.example.quizzproject.dao.QuizTypeDao;
import com.example.quizzproject.entity.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizTypeService {
    public QuizTypeDao quizTypeDao;
    @Autowired
    public QuizTypeService(QuizTypeDao quizTypeDao) {
        this.quizTypeDao = quizTypeDao;
    }
    @Transactional
    public List<QuizType> getAllQuizType() {
        return quizTypeDao.getAllQuizType();
    }
}
