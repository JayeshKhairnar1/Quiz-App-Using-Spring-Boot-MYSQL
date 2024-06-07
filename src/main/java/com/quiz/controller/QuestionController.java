package com.quiz.controller;

import com.quiz.model.Question;
import com.quiz.service.QuestionService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //Display All Questions
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    //Get questions by Category
    @GetMapping("/byCategory/{category}")
    public List<Question> getAllQuestions(@PathVariable String category) {
        return questionService.getAllQuestions(category);
    }

    //Add new question
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    //Adding multiple questions using JSON Array.
    @PostMapping("/addList")
    @ResponseStatus(HttpStatus.CREATED)
    public String addQuestion(@RequestBody List<Question> list){
        return questionService.addArrayQuestion(list);
    }
}
