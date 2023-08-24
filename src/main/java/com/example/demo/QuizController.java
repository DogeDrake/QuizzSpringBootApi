package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

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

    @GetMapping("/quizzes/{quizId}/random-questions")
    public ResponseEntity<List<QuestionDetails>> getRandomQuestionsForQuiz(@PathVariable Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Quiz quiz = optionalQuiz.get();
        List<Question> questions = questionRepository.findByQuiz(quiz);

        // Verificar si hay suficientes preguntas para seleccionar 20
        if (questions.size() < 10) {
            return ResponseEntity.badRequest().build();
        }

        // Mezclar las preguntas en un orden aleatorio
        Collections.shuffle(questions);

        // Seleccionar las primeras 20 preguntas mezcladas
        List<Question> randomQuestions = questions.subList(0, 10);

        // Mapear las preguntas y respuestas a QuestionDetails
        List<QuestionDetails> questionDetailsList = new ArrayList<>();
        for (Question question : randomQuestions) {
            List<Answer> answers = answerRepository.findByQuestion(question);
            QuestionDetails questionDetails = new QuestionDetails(question, answers);
            questionDetailsList.add(questionDetails);
        }

        return ResponseEntity.ok(questionDetailsList);
    }

    @GetMapping("/quizzes/{quizId}/random-questions-answers")
    public ResponseEntity<List<QuestionWithCorrectAnswer>> getRandomQuestionsForQuizPlus(@PathVariable Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Quiz quiz = optionalQuiz.get();
        List<Question> questions = questionRepository.findByQuiz(quiz);

        // Verificar si hay suficientes preguntas para seleccionar 20
        if (questions.size() < 10) {
            return ResponseEntity.badRequest().build();
        }

        // Mezclar las preguntas en un orden aleatorio
        Collections.shuffle(questions);

        // Seleccionar las primeras 20 preguntas mezcladas
        List<Question> randomQuestions = questions.subList(0, 10);

        // Mapear las preguntas y respuestas a QuestionWithCorrectAnswer
        List<QuestionWithCorrectAnswer> questionWithCorrectAnswerList = new ArrayList<>();
        for (Question question : randomQuestions) {
            List<Answer> answers = answerRepository.findByQuestion(question);

            // Encuentra la respuesta correcta
            Answer correctAnswer = answers.stream()
                    .filter(Answer::isIsCorrect)
                    .findFirst()
                    .orElse(null);

            QuestionWithCorrectAnswer questionWithCorrectAnswer = new QuestionWithCorrectAnswer(question,
                    correctAnswer);
            questionWithCorrectAnswerList.add(questionWithCorrectAnswer);
        }

        return ResponseEntity.ok(questionWithCorrectAnswerList);
    }

    @GetMapping("/quizzes/{quizId}/random-questions-and-answers")
    public ResponseEntity<List<QuizQuestionDTO>> getRandomQuestionsForQuizminus(@PathVariable Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Quiz quiz = optionalQuiz.get();
        List<Question> questions = questionRepository.findByQuiz(quiz);

        // Verificar si hay suficientes preguntas para seleccionar
        if (questions.size() < 10) {
            return ResponseEntity.badRequest().build();
        }

        // Mezclar las preguntas en un orden aleatorio
        Collections.shuffle(questions);

        // Seleccionar las primeras preguntas mezcladas
        List<Question> randomQuestions = questions.subList(0, 10);

        // Mapear las preguntas y respuestas a QuizQuestionDTO
        List<QuizQuestionDTO> quizQuestionDTOs = new ArrayList<>();
        for (Question question : randomQuestions) {
            List<Answer> answers = answerRepository.findByQuestion(question);

            Answer correctAnswer = answers.stream()
                    .filter(Answer::isIsCorrect)
                    .findFirst()
                    .orElse(null);

            List<AnswerDTO> answerDTOs = answers.stream()
                    .map(answer -> new AnswerDTO(answer.getAnswerId(), answer.getAnswerText(), answer.isIsCorrect()))
                    .collect(Collectors.toList());

            QuizDTO quizDTO = new QuizDTO(quiz.getQuizId(), quiz.getQuizName());

            QuizQuestionDTO quizQuestionDTO = new QuizQuestionDTO();
            quizQuestionDTO.setQuestionId(question.getQuestionId());
            quizQuestionDTO.setQuestionText(question.getQuestionText());
            quizQuestionDTO.setQuiz(quizDTO);
            quizQuestionDTO.setAllAnswers(answerDTOs);
            quizQuestionDTO
                    .setCorrectAnswer(new AnswerDTO(correctAnswer.getAnswerId(), correctAnswer.getAnswerText(), true));

            quizQuestionDTOs.add(quizQuestionDTO);
        }

        return ResponseEntity.ok(quizQuestionDTOs);
    }

    @GetMapping("/quizzes/{quizId}/themed-random-question")
    public ResponseEntity<QuestionWithAllAnswers> getRandomQuestionForQuiz(@PathVariable Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Quiz quiz = optionalQuiz.get();
        List<Question> questions = questionRepository.findByQuiz(quiz);

        if (questions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Elegir una pregunta aleatoria
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        Question randomQuestion = questions.get(randomIndex);

        List<Answer> answers = answerRepository.findByQuestion(randomQuestion);
        Answer correctAnswer = answers.stream()
                .filter(Answer::isIsCorrect)
                .findFirst()
                .orElse(null);

        QuestionWithAllAnswers questionWithAllAnswers = new QuestionWithAllAnswers(randomQuestion, answers,
                correctAnswer);
        return ResponseEntity.ok(questionWithAllAnswers);
    }

    @GetMapping("/quizzes/all-random-question")
    public ResponseEntity<QuestionWithAllAnswers> getRandomQuestion() {
        List<Question> allQuestions = questionRepository.findAll();

        if (allQuestions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Elegir una pregunta aleatoria
        Random random = new Random();
        int randomIndex = random.nextInt(allQuestions.size());
        Question randomQuestion = allQuestions.get(randomIndex);

        List<Answer> answers = answerRepository.findByQuestion(randomQuestion);
        Answer correctAnswer = answers.stream()
                .filter(Answer::isIsCorrect)
                .findFirst()
                .orElse(null);

        QuestionWithAllAnswers questionWithAllAnswers = new QuestionWithAllAnswers(randomQuestion, answers,
                correctAnswer);
        return ResponseEntity.ok(questionWithAllAnswers);
    }

}
