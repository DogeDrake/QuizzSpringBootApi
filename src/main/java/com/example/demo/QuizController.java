package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final QuizRepository quizRepository;

    public QuizController(QuestionRepository questionRepository, AnswerRepository answerRepository,
            QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.quizRepository = quizRepository;
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionRepository.save(question);
        return ResponseEntity.ok(createdQuestion);
    }

    @GetMapping("/questions/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            return ResponseEntity.ok(question);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/questions/{questionId}/answers")
    public ResponseEntity<Answer> createAnswer(@PathVariable Long questionId, @RequestBody Answer answer) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            answer.setQuestion(question);
            Answer createdAnswer = answerRepository.save(answer);
            return ResponseEntity.ok(createdAnswer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/questions/{questionId}/answers")
    public ResponseEntity<List<Answer>> getAnswersForQuestion(@PathVariable Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            List<Answer> answers = answerRepository.findByQuestion(question);
            return ResponseEntity.ok(answers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/answers/{answerId}")
    public ResponseEntity<Answer> getAnswer(@PathVariable Long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        if (optionalAnswer.isPresent()) {
            Answer answer = optionalAnswer.get();
            return ResponseEntity.ok(answer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/questions/{questionId}/details")
    public ResponseEntity<QuestionDetails> getQuestionDetails(@PathVariable Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            List<Answer> answers = answerRepository.findByQuestion(question);
            QuestionDetails questionDetails = new QuestionDetails(question, answers);
            return ResponseEntity.ok(questionDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<Quiz>> getQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/quizzes/{quizId}/questions")
    public ResponseEntity<List<QuestionDetails>> getQuestionsForQuiz(@PathVariable Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            List<Question> questions = questionRepository.findByQuiz(quiz);
            List<QuestionDetails> questionDetailsList = new ArrayList<>();

            for (Question question : questions) {
                List<Answer> answers = answerRepository.findByQuestion(question);
                QuestionDetails questionDetails = new QuestionDetails(question, answers);
                questionDetailsList.add(questionDetails);
            }

            return ResponseEntity.ok(questionDetailsList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
     * @GetMapping("/questions/count")
     * public ResponseEntity<Long> getTotalQuestionCount() {
     * Long totalQuestionCount = questionRepository.count();
     * return ResponseEntity.ok(totalQuestionCount);
     * }
     * 
     * @GetMapping("/{quizId}/questions/count")
     * public ResponseEntity<Long> getQuestionCountByQuiz(@PathVariable Long quizId)
     * {
     * Long questionCount = questionRepository.countByQuizId(quizId);
     * return ResponseEntity.ok(questionCount);
     * }
     */

}
