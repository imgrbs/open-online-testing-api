package com.depa.exam.controller;

import com.depa.exam.dto.QuestionDTO;
import com.depa.exam.dto.impl.QuestionDTOImpl;
import com.depa.exam.service.QuestionService;
import com.depa.observer.CustomSpringEvent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter
@RestController
@CrossOrigin(origins = "*")
@Component
public class QuestionController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        List<QuestionDTO> questions = questionService.getQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTOImpl request) {
        QuestionDTO question = questionService.createQuestion(request);

        applicationEventPublisher.publishEvent(new CustomSpringEvent(question, "question_created"));
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}
