package com.alphasolutions.questions.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions_and_answers")
public class Question {
    
    @Id
    private Long id;
    private String question;
    private String answer;
    @Column(name = "wrong_answer")
    private String wrongAnswer;
    @Column(name = "secondwrong_answer")
    private String secondwrongAnswer;
    private String topic;

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
    public String getSecondwrongAnswer() {
        return secondwrongAnswer;
    }
    public void setSecondwrongAnswer(String secondwrongAnswer) {
        this.secondwrongAnswer = secondwrongAnswer;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder
        .append("question=")
        .append(question)
        .append(";")
        .append("answer=")
        .append(answer)
        .append(":")
        .append("wronganswer1=")
        .append(wrongAnswer)
        .append(";")
        .append("wronganswer2=")
        .append(secondwrongAnswer)
        .append(";");
        return builder.toString();
    }

}