package com.depa.form.service;

import com.depa.form.dto.ExamDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.repository.ExamRepository;

import java.util.List;

public interface ExamService {
    void setExamRepository(ExamRepository mockExamRepository);

    Exam createForm(Exam exam);

    List<Exam> getForms();

    Exam getFormById(String uid);

    Exam toForm(ExamDTO examDTO);

    ExamDTO toFormDTO(Exam exam);
}
