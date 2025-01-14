package com.karan.quiz_service.service;

import com.karan.quiz_service.DAO.QuizRepo;
import com.karan.quiz_service.feign.QuizInterface;
import com.karan.quiz_service.model.QuestionWrapper;
import com.karan.quiz_service.model.Quiz;
import com.karan.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<String> createQuize(String category, int numQ, String title) {
        List<Integer> question=quizInterface.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(question);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Integer> questionsIds=quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionFromId(questionsIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> response) {
        ResponseEntity<Integer> score=quizInterface.getScore(response);
        return score;
    }
}
