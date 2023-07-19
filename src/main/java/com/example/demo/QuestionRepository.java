package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Métodos de repositorio

    /*
     * long countByQuiz(Quiz quiz);
     */
    List<Question> findByQuiz(Quiz quiz);

}