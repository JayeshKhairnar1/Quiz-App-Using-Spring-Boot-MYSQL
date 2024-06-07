package com.quiz.service;

import com.quiz.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();
    List<Question> getAllQuestions(String category);
    String addQuestion(Question question);
    String addArrayQuestion(List<Question> list);


}
