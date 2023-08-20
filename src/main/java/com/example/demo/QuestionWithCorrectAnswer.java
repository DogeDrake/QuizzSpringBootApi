package com.example.demo;

public class QuestionWithCorrectAnswer extends Question {
    private Answer correctAnswer;

    public QuestionWithCorrectAnswer(Question question, Answer correctAnswer) {
        super(question.getQuestionId(), question.getQuestionText(), question.getQuiz());
        this.correctAnswer = correctAnswer;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
