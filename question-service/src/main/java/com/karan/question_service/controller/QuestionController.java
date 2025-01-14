package com.karan.question_service.controller;


import com.karan.question_service.model.Question;
import com.karan.question_service.model.QuestionWrapper;
import com.karan.question_service.model.Response;
import com.karan.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("getQuestions")
    public ResponseEntity<List<Question>> getQuestions() {
        System.out.println("Instance used " + environment.getProperty("local.server.port"));
        return questionService.getQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        System.out.println(questionService.getQuestionsByCategory(category));
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestions")
    public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions) {
        return questionService.addQuestions(questions);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName,@RequestParam Integer questionNo) {
        return questionService.getQuestionForQuiz(categoryName,questionNo);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFormIds(@RequestBody List<Integer> questionId) {
        System.out.println("Instance used " + environment.getProperty("local.server.port"));
        return questionService.getQuestionFromId(questionId);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getQuestionScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }
}
