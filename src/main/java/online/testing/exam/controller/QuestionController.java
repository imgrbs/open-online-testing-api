package online.testing.exam.controller;

import online.testing.exam.dto.QuestionDTO;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.service.CategoryService;
import online.testing.exam.service.QuestionService;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter
@RestController
@CrossOrigin(origins = "*")
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
        QuestionDTO question = questionService.createQuestion(request);
        question.getCategories().forEach(categoryDTO -> {
            categoryService.createCategory(categoryDTO);
        });
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}
