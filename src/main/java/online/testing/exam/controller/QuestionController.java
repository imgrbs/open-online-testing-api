package online.testing.exam.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import online.testing.exam.dto.QuestionDTO;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.service.CategoryService;
import online.testing.exam.service.QuestionService;
import online.testing.user.dto.UserPrincipal;

@Setter
@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/questions")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<QuestionDTO>> getQuestions(Principal principal) {
        UserPrincipal userPrincipal = (UserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        List<QuestionDTO> questions = questionService.getQuestionsByUserId(userPrincipal.getId());
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionDTO> createQuestion(
            Principal principal,
            @RequestBody QuestionDTOImpl request
     ) {
        UserPrincipal userPrincipal = (UserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        QuestionDTO question = questionService.createQuestion(request);
        question.setOwnerId(userPrincipal.getId());
        question.getCategories().forEach(categoryDTO -> {
            categoryService.createCategory(categoryDTO);
        });
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}
