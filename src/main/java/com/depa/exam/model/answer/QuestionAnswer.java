/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.model.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Test
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class QuestionAnswer {
    
    private String questionId;
    
    private String answer;
    
    private boolean isGradeQuestionAnswerFinish;
    
}
