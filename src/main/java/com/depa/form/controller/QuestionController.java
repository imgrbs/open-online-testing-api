package com.depa.form.controller;

import com.depa.form.dto.QuestionDTO;
import com.depa.form.model.question.Question;
import com.depa.form.service.QuestionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Setter
@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }
}
