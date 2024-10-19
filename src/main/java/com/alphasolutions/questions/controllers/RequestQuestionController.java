package com.alphasolutions.questions.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphasolutions.questions.model.QuestionDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getquestion")
    public ResponseEntity<String> getQuestion(@RequestHeader(value = "x-api-key") String key, @RequestParam String topic) {
        if(!apiKey.equals(key)){
            return ResponseEntity.badRequest().body("Negado");
        }
        return ResponseEntity.ok().body(questionDAO.findByTopic(topic).toString());
    }
    
}
