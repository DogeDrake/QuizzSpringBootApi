package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // Métodos de repositorio
    /*
     * @Query("SELECT COUNT(q) FROM Question q")
     * long getTotalQuestionCount();
     * 
     * @Query("SELECT COUNT(q.questions) FROM Quiz q WHERE q.quizId = :quizId")
     * long getQuestionCountByQuizId(Long quizId);
     */
}