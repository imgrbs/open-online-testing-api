/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.model.answer;

import java.util.List;
import javax.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Test
 */
@Document("answers")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class ExamAnswer {
    
    @Id
    private String answerId;
    
    private String userId;
    
    private double score;
    
    private List<QuestionAnswer> questionAnswerList;
    
    private boolean isGradingExamAnswerFinish;

    @Override
    public String toString() {
        return "ExamAnswer{" + "answerId=" + answerId + ", userId=" + userId + ", score=" + score + ", questionAnswerList=" + questionAnswerList + ", isGradingExamAnswerFinish=" + isGradingExamAnswerFinish + '}';
    }


}
