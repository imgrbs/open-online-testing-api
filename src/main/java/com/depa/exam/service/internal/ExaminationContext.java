/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.service.internal;

import org.bson.types.ObjectId;

/**
 *
 * @author Test
 */

public class ExaminationContext {
    
    private ExaminationStrategy examinationContext;

    public ExaminationStrategy getExaminationContext() {
        return examinationContext;
    }

    public void setExaminationContext(ExaminationStrategy examinationContext) {
        this.examinationContext = examinationContext;
    }

    void generateExaminationByExamId(ObjectId examId) {
        this.examinationContext.generateExamination(examId);
    }
    
}
