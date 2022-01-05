package com.example.quizzproject.dao;

import com.example.quizzproject.entity.Choice;

import java.util.List;

public interface ChoiceDao {
    List<Choice> getChoiceByQuestion(int questionId);
}
