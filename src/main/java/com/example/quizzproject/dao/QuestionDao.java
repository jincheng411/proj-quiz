package com.example.quizzproject.dao;

import com.example.quizzproject.entity.Choice;
import com.example.quizzproject.entity.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionByQuizType(int quizTypeId);
    Question getQuestionById(int id);
    List<Question> getQuestionBySubmissionId(int sId);
}
