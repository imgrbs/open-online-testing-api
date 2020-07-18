package com.depa.testing.system.exam.controller;

import com.depa.testing.system.exam.dto.ExamDTO;
import com.depa.testing.system.exam.dto.impl.ExamDTOImpl;
import com.depa.testing.system.exam.service.ExamService;
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

    @PostMapping("/exam")
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTOImpl exam) {
        ExamDTO response = examService.createExam(exam);
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
