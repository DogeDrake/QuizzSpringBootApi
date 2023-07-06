package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String quizName;

    // Getters and setters

    public Quiz() {
    }

    public Quiz(Long quizId, String quizName) {
        this.quizId = quizId;
        this.quizName = quizName;
    }

    public Long getQuizId() {
        return this.quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return this.quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Quiz quizId(Long quizId) {
        setQuizId(quizId);
        return this;
    }

    public Quiz quizName(String quizName) {
        setQuizName(quizName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Quiz)) {
            return false;
        }
        Quiz quiz = (Quiz) o;
        return Objects.equals(quizId, quiz.quizId) && Objects.equals(quizName, quiz.quizName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId, quizName);
    }

    @Override
    public String toString() {
        return "{" +
                " quizId='" + getQuizId() + "'" +
                ", quizName='" + getQuizName() + "'" +
                "}";
    }

}