package com.alphasolutions.questions.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphasolutions.questions.model.Question;
import com.alphasolutions.questions.model.QuestionDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("question")
public class RequestQuestionController {
    @Value("${x-api-key}")
    private String apiKey;

    @Autowired
    QuestionDAO questionDAO;

    @GetMapping(path = "/getquestion",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getQuestion(@RequestHeader(value = "x-api-key") String key, @RequestParam String topic)  {
        if(!apiKey.equals(key)){
            return ResponseEntity.badRequest().body("Negado, verifique a api key");
        }

        List<Question> questions = questionDAO.findByTopic(topic);
        
        if(questions.isEmpty()){
            return ResponseEntity.badRequest().body("Não tem esse tipo de questão ainda");
        }
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/question")
    public ResponseEntity<?> reviveTheSystem() {
        return ResponseEntity.ok("Pulsar sended");
    }
    
    
}
