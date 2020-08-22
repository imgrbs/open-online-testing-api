/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.dto.impl;

import com.depa.exam.dto.ExamAnswerDTO;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

/**
 *
 * @author Test
 */
@NoArgsConstructor
@Getter
@Setter
public class ExamAnswerDTOImpl implements ExamAnswerDTO{
    
    private ObjectId questionId;
    
    private String questionType;
    
    private List<String> answer;

    @Override
    public String toString() {
        return "ExamAnswerDTOImpl{" + "questionId=" + questionId + ", questionType=" + questionType + ", answer=" + answer + '}';
    }
    
}
