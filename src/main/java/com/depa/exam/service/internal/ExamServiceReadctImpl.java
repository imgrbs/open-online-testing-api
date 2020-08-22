/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.repository.ExamRepository;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Test
 */
@Service
public class ExamServiceReadctImpl extends ExamServiceImpl{
    
    @Autowired
    private ExamRepository examRepository;

    @Override
    public List<ExamDTO> getExams() {
        List<Exam> queryExams = this.examRepository.findAll();
        ArrayList<ExamDTO> exams = new ArrayList<>();
        queryExams.forEach(exam -> exams.add(toExamExcludeQuestionDTOImpl(exam)));
        return exams;
    }
    
    @Override
    public ExamDTO getExamById(ObjectId id) {
        return toExamExcludeQuestionDTOImpl(examRepository.findById(id).get());
    }
    
    public ExamDTO toExamExcludeQuestionDTOImpl(Exam exam) {
        return new ExamExcludeQuestionDTOImpl(exam);
    }
    
}
