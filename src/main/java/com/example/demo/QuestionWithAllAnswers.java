package com.example.demo;

import java.util.List;
import java.util.Objects;

public class QuestionWithAllAnswers {
    private Long questionId;
    private String questionText;
    private Long quizId;
    private String quizName;
    private List<Answer> allAnswers;
    private Long correctAnswerId;

    public QuestionWithAllAnswers(Long questionId, String questionText, Long quizId, String quizName,
            List<Answer> allAnswers, Long correctAnswerId) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.quizId = quizId;
        this.quizName = quizName;
        this.allAnswers = allAnswers;
        this.correctAnswerId = correctAnswerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public List<Answer> getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(List<Answer> allAnswers) {
        this.allAnswers = allAnswers;
    }

    public Long getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(Long correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    // Resto de los métodos de la clase

    public QuestionWithAllAnswers() {
    }

    public QuestionWithAllAnswers questionId(Long questionId) {
        setQuestionId(questionId);
        return this;
    }

    public QuestionWithAllAnswers questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public QuestionWithAllAnswers quizId(Long quizId) {
        setQuizId(quizId);
        return this;
    }

    public QuestionWithAllAnswers quizName(String quizName) {
        setQuizName(quizName);
        return this;
    }

    public QuestionWithAllAnswers allAnswers(List<Answer> allAnswers) {
        setAllAnswers(allAnswers);
        return this;
    }

    public QuestionWithAllAnswers correctAnswerId(Long correctAnswerId) {
        setCorrectAnswerId(correctAnswerId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuestionWithAllAnswers)) {
            return false;
        }
        QuestionWithAllAnswers questionWithAllAnswers = (QuestionWithAllAnswers) o;
        return Objects.equals(questionId, questionWithAllAnswers.questionId)
                && Objects.equals(questionText, questionWithAllAnswers.questionText)
                && Objects.equals(quizId, questionWithAllAnswers.quizId)
                && Objects.equals(quizName, questionWithAllAnswers.quizName)
                && Objects.equals(allAnswers, questionWithAllAnswers.allAnswers)
                && Objects.equals(correctAnswerId, questionWithAllAnswers.correctAnswerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionText, quizId, quizName, allAnswers, correctAnswerId);
    }

    @Override
    public String toString() {
        return "{" +
                " questionId='" + getQuestionId() + "'" +
                ", questionText='" + getQuestionText() + "'" +
                ", quizId='" + getQuizId() + "'" +
                ", quizName='" + getQuizName() + "'" +
                ", allAnswers='" + getAllAnswers() + "'" +
                ", correctAnswerId='" + getCorrectAnswerId() + "'" +
                "}";
    }

}
