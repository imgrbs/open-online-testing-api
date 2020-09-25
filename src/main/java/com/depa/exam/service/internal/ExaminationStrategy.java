/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamDTO;
import java.util.Collections;
import org.bson.types.ObjectId;

/**
 *
 * @author Test
 */
public interface ExaminationStrategy {
    
    public ExamDTO generateExamination(ExamDTO exam);
    
}
