package com.alphasolutions.questions.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "questions_and_answers")
public class Question {

    @Id
    private Long id;

    private String question;

    private String answer;

    @Column(name = "wrong_answer")
    @JsonProperty("wrong_answer")
    private String wrongAnswer;

    @Column(name = "secondwrong_answer")
    @JsonProperty("second_wrong_answer")
    private String secondWrongAnswer;

    private String topic;

    public Question() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public String getSecondWrongAnswer() {
        return secondWrongAnswer;
    }

    public void setSecondWrongAnswer(String secondWrongAnswer) {
        this.secondWrongAnswer = secondWrongAnswer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
