package com.quiz.service;

import com.quiz.model.QuestionWrapper;
import com.quiz.model.Response;

import java.util.List;

public interface QuizService {
        String createQuiz(String  category, int numQ, String title);
        List<QuestionWrapper> getQuizQuestions(Integer id);
        int calculateResult(int id, List<Response> responses);
}
