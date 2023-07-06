package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionText;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    // Getters and setters

    public Question() {
    }

    public Question(Long questionId, String questionText, Quiz quiz) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.quiz = quiz;
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Quiz getQuiz() {
        return this.quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question questionId(Long questionId) {
        setQuestionId(questionId);
        return this;
    }

    public Question questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public Question quiz(Quiz quiz) {
        setQuiz(quiz);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Question)) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(questionId, question.questionId) && Objects.equals(questionText, question.questionText)
                && Objects.equals(quiz, question.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionText, quiz);
    }

    @Override
    public String toString() {
        return "{" +
                " questionId='" + getQuestionId() + "'" +
                ", questionText='" + getQuestionText() + "'" +
                ", quiz='" + getQuiz() + "'" +
                "}";
    }

}