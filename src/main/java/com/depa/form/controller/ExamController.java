package com.depa.form.controller;

import com.depa.form.dto.ExamDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.service.ExamService;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ExamController {

    @Autowired
    @Setter(AccessLevel.PROTECTED)
    private ExamService examService;

    @PostMapping("/exam")
    public ExamDTO createExam(@RequestBody ExamDTO examDTO) {
        Exam exam = examService.toForm(examDTO);
        Exam responseExam = examService.createForm(exam);
        return examService.toFormDTO(responseExam);
    }

    @GetMapping("/exam/{uid}")
    public ExamDTO getExamByUid(@PathVariable String uid) {
        Exam responseExam = examService.getFormById(uid);
        return examService.toFormDTO(responseExam);
    }

    @GetMapping("/exams")
    public List<ExamDTO> getExams() {
        List<Exam> exams = examService.getForms();

        List<ExamDTO> responseForms = new ArrayList<>();
        exams.forEach(form -> {
            responseForms.add(examService.toFormDTO(form));
        });

        return responseForms;
    }

}
