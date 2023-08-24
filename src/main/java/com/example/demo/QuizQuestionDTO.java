package com.example.demo;

import java.util.List;
import java.util.Objects;

public class QuizQuestionDTO {
    private Long questionId;
    private String questionText;
    private QuizDTO quiz;
    private List<AnswerDTO> allAnswers;
    private AnswerDTO correctAnswer;

    // Getters and setters

    public QuizQuestionDTO() {
    }

    public QuizQuestionDTO(Long questionId, String questionText, QuizDTO quiz, List<AnswerDTO> allAnswers,
            AnswerDTO correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.quiz = quiz;
        this.allAnswers = allAnswers;
        this.correctAnswer = correctAnswer;
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

    public QuizDTO getQuiz() {
        return this.quiz;
    }

    public void setQuiz(QuizDTO quiz) {
        this.quiz = quiz;
    }

    public List<AnswerDTO> getAllAnswers() {
        return this.allAnswers;
    }

    public void setAllAnswers(List<AnswerDTO> allAnswers) {
        this.allAnswers = allAnswers;
    }

    public AnswerDTO getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(AnswerDTO correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public QuizQuestionDTO questionId(Long questionId) {
        setQuestionId(questionId);
        return this;
    }

    public QuizQuestionDTO questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public QuizQuestionDTO quiz(QuizDTO quiz) {
        setQuiz(quiz);
        return this;
    }

    public QuizQuestionDTO allAnswers(List<AnswerDTO> allAnswers) {
        setAllAnswers(allAnswers);
        return this;
    }

    public QuizQuestionDTO correctAnswer(AnswerDTO correctAnswer) {
        setCorrectAnswer(correctAnswer);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuizQuestionDTO)) {
            return false;
        }
        QuizQuestionDTO quizQuestionDTO = (QuizQuestionDTO) o;
        return Objects.equals(questionId, quizQuestionDTO.questionId)
                && Objects.equals(questionText, quizQuestionDTO.questionText)
                && Objects.equals(quiz, quizQuestionDTO.quiz) && Objects.equals(allAnswers, quizQuestionDTO.allAnswers)
                && Objects.equals(correctAnswer, quizQuestionDTO.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionText, quiz, allAnswers, correctAnswer);
    }

    @Override
    public String toString() {
        return "{" +
                " questionId='" + getQuestionId() + "'" +
                ", questionText='" + getQuestionText() + "'" +
                ", quiz='" + getQuiz() + "'" +
                ", allAnswers='" + getAllAnswers() + "'" +
                ", correctAnswer='" + getCorrectAnswer() + "'" +
                "}";
    }

}
