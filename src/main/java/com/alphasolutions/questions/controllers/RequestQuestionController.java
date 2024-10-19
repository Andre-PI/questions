package com.alphasolutions.questions.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphasolutions.questions.model.Question;
import com.alphasolutions.questions.model.QuestionDAO;

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
    public Map<Long,Question> getQuestion(@RequestHeader(value = "x-api-key") String key, @RequestParam String topic)  {
        if(!apiKey.equals(key)){
            return null;
        }

        List<Question> questions = questionDAO.findByTopic(topic);
        
        if(questions.isEmpty()){
            return null;
        }
        Map<Long, Question> questionsMap = questions.stream()
            .collect(Collectors.toMap(Question::getId, question -> question));
        return questionsMap;
    }
    
}
