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

/**
 *
 * @author Test
 */
public class AdaptiveTesting extends ExamServiceImpl {

    @Override
    public ExamDTO generateExamination(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitExamAllAnswer(ObjectId examId, List<ExamAnswerDTOImpl> examAnswer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
