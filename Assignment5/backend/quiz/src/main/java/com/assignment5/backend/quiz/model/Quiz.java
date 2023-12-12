package com.assignment5.backend.quiz.model;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column
    private int numQuestions;

    @Column int quizNumber;
}
