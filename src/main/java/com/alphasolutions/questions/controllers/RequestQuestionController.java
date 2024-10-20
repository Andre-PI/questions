package com.alphasolutions.questions.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphasolutions.questions.model.Question;
import com.alphasolutions.questions.model.QuestionDAO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("question")
public class RequestQuestionController {
    @Value("${x-api-key}")
    private String apiKey;

    @Autowired
    QuestionDAO questionDAO;

    @GetMapping(path = "/getquestion",produces = MediaType.APPLICATION_JSON_VALUE)
    public Question getQuestion(@RequestHeader(value = "x-api-key") String key, @RequestParam String topic)  {
        if(!apiKey.equals(key)){
            return null;
        }

        List<Question> questions = questionDAO.findByTopic(topic);
        
        if(questions.isEmpty()){
            return null;
        }
        Question question = questions.get(0);
        
        return new Question(question.getQuestion(),question.getAnswer(),question.getWrongAnswer(),question.getSecondWrongAnswer(),question.getTopic());

    }
    
}
