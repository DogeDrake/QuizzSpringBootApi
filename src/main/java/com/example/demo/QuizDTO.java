package com.example.demo;

import java.util.Objects;

public class QuizDTO {
    private Long quizId;
    private String quizName;

    // Getters and setters

    public QuizDTO() {
    }

    public QuizDTO(Long quizId, String quizName) {
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

    public QuizDTO quizId(Long quizId) {
        setQuizId(quizId);
        return this;
    }

    public QuizDTO quizName(String quizName) {
        setQuizName(quizName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuizDTO)) {
            return false;
        }
        QuizDTO quizDTO = (QuizDTO) o;
        return Objects.equals(quizId, quizDTO.quizId) && Objects.equals(quizName, quizDTO.quizName);
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
