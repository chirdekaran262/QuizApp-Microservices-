package com.karan.quiz_service.feign;


import com.karan.quiz_service.model.QuestionWrapper;
import com.karan.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

     @GetMapping("questions/generate")
     ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName,@RequestParam Integer questionNo);

     @PostMapping("questions/getQuestions")
     ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionId);

     @PostMapping("questions/getScore")
     ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
