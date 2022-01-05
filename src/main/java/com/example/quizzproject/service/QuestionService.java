package com.example.quizzproject.service;

import com.example.quizzproject.dao.ChoiceDao;
import com.example.quizzproject.dao.QuestionDao;
import com.example.quizzproject.entity.Choice;
import com.example.quizzproject.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    public QuestionDao questionDao;
    public ChoiceDao choiceDao;
    @Autowired
    public QuestionService(QuestionDao questionDao, ChoiceDao choiceDao) {
        this.questionDao = questionDao;
        this.choiceDao = choiceDao;
    }

    @Transactional
    public List<Question> getQuestionByQuizType(int quizId) {
        return questionDao.getQuestionByQuizType(quizId);
    }

    @Transactional
    public List<Integer> getQuestionIdByQuizType(int quizId) {
        return questionDao.getQuestionByQuizType(quizId).stream().map(q->q.getId()).collect(Collectors.toList());
    }

    @Transactional
    public Question getQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }
    @Transactional
    public List<Choice> getChoiceByQuestion(int questionId) {
        return choiceDao.getChoiceByQuestion(questionId);
    }

    @Transactional
    public Map<Integer, List<Choice>> getAllChoicesByQuestionList(Collection<Question> questions) {
        Map<Integer, List<Choice>> choiceList = new HashMap<>();
        for(Question q : questions) {
            choiceList.put(q.getId(), getChoiceByQuestion(q.getId()));
        }
        return choiceList;
    }
    @Transactional
    public List<Question> getQuestionBySubmissionId(int Sid) {
        return questionDao.getQuestionBySubmissionId(Sid);
    }
}
