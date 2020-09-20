/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamAnswerDTOImpl;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 *
 * @author Test
 */
@Service
public class AdaptiveTesting implements ExaminationStrategy {

    @Override
    public ExamDTO generateExamination(ExamDTO exam) {
        System.out.println("==== Adaptive Testing ====");
        return null;
    }
    
}
