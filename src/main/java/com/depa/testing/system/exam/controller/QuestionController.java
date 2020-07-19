package com.depa.testing.system.exam.controller;

import com.depa.testing.system.category.model.Category;
import com.depa.testing.system.category.service.CategoryService;
import com.depa.testing.system.exam.dto.CategoryDTO;
import com.depa.testing.system.exam.dto.QuestionDTO;
import com.depa.testing.system.exam.dto.impl.QuestionDTOImpl;
import com.depa.testing.system.exam.service.QuestionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Setter
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        List<QuestionDTO> questions = questionService.getQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTOImpl request) {
        List<Category> categories = new ArrayList<>();
        for (Category aCategory : request.getCategories()) {
            Category wow = categoryService.createCategory(aCategory);
            categories.add(wow);
        }
        request.setCategories(categories);
        QuestionDTO question = questionService.createQuestion(request);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}
