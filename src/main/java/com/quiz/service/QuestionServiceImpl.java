package com.quiz.service;

import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements  QuestionService{

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestions(String category) {
        return  questionRepository.findByCategory(category);
    }

    @Override
    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Question added Successfully.";
    }

    @Override
    public String addArrayQuestion(List<Question> list) {
        questionRepository.saveAll(list);
        return "Array Added";
    }


}
