package com.alphasolutions.questions.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface QuestionDAO extends JpaRepository<Question, Long> {
    List<Question> findByTopic(String topic);
}