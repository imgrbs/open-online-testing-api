package com.depa.exam.controller;

import com.depa.exam.dto.ExamAnswerDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamAnswerDTOImpl;
import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import com.depa.exam.service.CategoryService;
import com.depa.exam.service.ExamService;
import com.depa.exam.service.internal.ExamServiceImpl;
import java.util.Collections;
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
/**
 * /v2 is method that extend by son for safety migration
 */
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/exam")
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTOImpl exam) {
        System.out.println("== Contraoller Create Exam=");
        exam.getQuestions().forEach(categoryDTO -> {
            System.out.println(categoryDTO.getCategories());
            categoryDTO.getCategories().forEach((category) -> {
                categoryService.createCategory(category);
            });
        });
        System.out.println("!!!!! Get Question ID !!!!");
        System.out.println(exam.getQuestions().get(0).getId());
        ExamDTO createdExam = examService.createExam(exam);
        return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
    }

    @GetMapping("/exam/{uid}")
    public ResponseEntity<ExamDTO> getExamByObjectId(@PathVariable String uid) {
        ExamDTO exam = examService.getExamById(uid);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/exam/{uid}/questions")
    public ResponseEntity<ExamDTO> getExamDetailById(@PathVariable String uid) {
        ExamDTO exam = examService.generateExamination(uid);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/exams")
    public ResponseEntity<List<ExamDTO>> getExams() {
        List<ExamDTO> exams = examService.getExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @PostMapping("/exam/{examId}/answer/submit")
    public ResponseEntity<ExamDTO> submitExamAllAnswer(@PathVariable String examId, @RequestBody List<ExamAnswerDTOImpl> examAnswerList) {
        examService.submitExamAllAnswer(examId, examAnswerList);
        System.out.println("=========");
        System.out.println(examAnswerList);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

//    @GetMapping("/v2/exams")
//    public ResponseEntity<List> getExamsImpl() {
//        List<ExamDTO> exams = examService.getExamsImpl();
//        return new ResponseEntity<>(exams, HttpStatus.OK);
//    }
//    @GetMapping("/exam/{uid}")
//    public ResponseEntity<ExamDTO> getExamByObjectIdImpl(@PathVariable ObjectId uid) {
//        ExamDTO exam = examService.getExamById(uid);
//        return new ResponseEntity<>(exam, HttpStatus.OK);
//    }
}
