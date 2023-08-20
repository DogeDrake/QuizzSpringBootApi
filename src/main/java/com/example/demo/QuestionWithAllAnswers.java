package com.example.demo;

import java.util.List;

public class QuestionWithAllAnswers extends Question {
    private List<Answer> allAnswers;
    private Answer correctAnswer;

    public QuestionWithAllAnswers(Question question, List<Answer> allAnswers, Answer correctAnswer) {
        super(question.getQuestionId(), question.getQuestionText(), question.getQuiz());
        this.allAnswers = allAnswers;
        this.correctAnswer = correctAnswer;
    }

    public List<Answer> getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(List<Answer> allAnswers) {
        this.allAnswers = allAnswers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
