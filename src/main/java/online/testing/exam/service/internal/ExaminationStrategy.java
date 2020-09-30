/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.testing.exam.service.internal;

import online.testing.exam.dto.ExamDTO;

/**
 *
 * @author Test
 */
public interface ExaminationStrategy {
    
    public ExamDTO generateExamination(ExamDTO exam);
    
}
