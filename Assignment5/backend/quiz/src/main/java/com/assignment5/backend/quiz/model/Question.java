package com.assignment5.backend.quiz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String questionText;

    @Column
    private String answer1;

    @Column
    private String answer2;

    @Column
    private String answer3;

    @Column
    private String answer4;

    public Question(String questionText, String answer1, String answer2, String answer3, String answer4){
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }


}
