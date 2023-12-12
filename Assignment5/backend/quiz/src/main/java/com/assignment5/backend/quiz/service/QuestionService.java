package com.assignment5.backend.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment5.backend.quiz.model.Question;
import com.assignment5.backend.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public boolean addquestion(String questionText, String answer1, String answer2, String answer3, String answer4){
        try{
            questionRepository.save(new Question(questionText, answer1, answer2, answer3, answer4));
            return true;
        } catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
