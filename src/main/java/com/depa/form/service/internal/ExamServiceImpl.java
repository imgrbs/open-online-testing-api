package com.depa.form.service.internal;

import com.depa.form.dto.ExamDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.repository.ExamRepository;
import com.depa.form.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public void setExamRepository(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Exam createForm(Exam exam) {
        System.out.println("Start Saving Create Form !!!!!!!!");
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getForms() {
        return this.examRepository.findAll();
    }

    @Override
    public Exam getFormById(String id) {
        return this.examRepository.findById(id).get();
    }

    @Override
    public Exam toForm(ExamDTO examDTO) {
        System.out.println("!!! Cast FormDTO to Form !!!");
        System.out.println(examDTO);
        return new Exam(examDTO);
    }

    @Override
    public ExamDTO toFormDTO(Exam exam) {
        return new ExamDTO(exam);
    }
}
