package com.karan.question_service.DAO;

import com.karan.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT q.id from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, Integer numQ);

    List<Question> findByCategory(String category);

    Question getQuestionById(int id);
}
