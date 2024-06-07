package com.quiz.controller;

import com.quiz.model.QuestionWrapper;
import com.quiz.model.Response;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizControler {
    @Autowired
     private QuizService quizService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id){
    return quizService.getQuizQuestions(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }


}
