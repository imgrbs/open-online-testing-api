package com.depa.exam.controller;

import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.service.CategoryService;
import com.depa.exam.service.ExamService;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter
@RestController
@CrossOrigin(origins = "*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/exam")
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTOImpl exam) {
        ExamDTO response = examService.createExam(exam);
        response.getCategories().forEach(categoryDTO -> {
            categoryService.createCategory(categoryDTO);
        });
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/exam/{uid}")
    public ResponseEntity<ExamDTO> getExamByObjectId(@PathVariable ObjectId uid) {
        ExamDTO exam = examService.getExamById(uid);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/exams")
    public ResponseEntity<List<ExamDTO>> getExams() {
        List<ExamDTO> exams = examService.getExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

}
