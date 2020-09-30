/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.testing.exam.service.internal;

import online.testing.exam.dto.ExamDTO;

import org.springframework.stereotype.Service;

/**
 *
 * @author Test
 */
@Service
public class ExaminationContext {

    private ExaminationStrategy examinationContext;

    public ExaminationStrategy getExaminationContext() {
        return examinationContext;
    }

    public void setExaminationContext(ExaminationStrategy examinationContext) {
        this.examinationContext = examinationContext;
    }

    public ExamDTO generateExamination(ExamDTO exam) {
        return this.examinationContext.generateExamination(exam);
    }

}
