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
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String answerText;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Getters and setters

    public Answer() {
    }

    public Answer(Long answerId, String answerText, boolean isCorrect, Question question) {
        this.answerId = answerId;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public Long getAnswerId() {
        return this.answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isIsCorrect() {
        return this.isCorrect;
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer answerId(Long answerId) {
        setAnswerId(answerId);
        return this;
    }

    public Answer answerText(String answerText) {
        setAnswerText(answerText);
        return this;
    }

    public Answer isCorrect(boolean isCorrect) {
        setIsCorrect(isCorrect);
        return this;
    }

    public Answer question(Question question) {
        setQuestion(question);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(answerId, answer.answerId) && Objects.equals(answerText, answer.answerText)
                && isCorrect == answer.isCorrect && Objects.equals(question, answer.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, answerText, isCorrect, question);
    }

    @Override
    public String toString() {
        return "{" +
                " answerId='" + getAnswerId() + "'" +
                ", answerText='" + getAnswerText() + "'" +
                ", isCorrect='" + isIsCorrect() + "'" +
                ", question='" + getQuestion() + "'" +
                "}";
    }

}