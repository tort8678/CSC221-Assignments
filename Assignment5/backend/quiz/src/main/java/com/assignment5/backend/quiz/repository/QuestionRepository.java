package com.assignment5.backend.quiz.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment5.backend.quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    
}
