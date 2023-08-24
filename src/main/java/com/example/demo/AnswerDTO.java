package com.example.demo;

import java.util.Objects;

public class AnswerDTO {
    private Long answerId;
    private String answerText;
    private boolean isCorrect;

    // Getters and setters

    public AnswerDTO() {
    }

    public AnswerDTO(Long answerId, String answerText, boolean isCorrect) {
        this.answerId = answerId;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
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

    public AnswerDTO answerId(Long answerId) {
        setAnswerId(answerId);
        return this;
    }

    public AnswerDTO answerText(String answerText) {
        setAnswerText(answerText);
        return this;
    }

    public AnswerDTO isCorrect(boolean isCorrect) {
        setIsCorrect(isCorrect);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AnswerDTO)) {
            return false;
        }
        AnswerDTO answerDTO = (AnswerDTO) o;
        return Objects.equals(answerId, answerDTO.answerId) && Objects.equals(answerText, answerDTO.answerText)
                && isCorrect == answerDTO.isCorrect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, answerText, isCorrect);
    }

    @Override
    public String toString() {
        return "{" +
                " answerId='" + getAnswerId() + "'" +
                ", answerText='" + getAnswerText() + "'" +
                ", isCorrect='" + isIsCorrect() + "'" +
                "}";
    }
}
