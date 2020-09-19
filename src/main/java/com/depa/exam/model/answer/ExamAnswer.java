/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.model.answer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
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
    
    private ObjectId answerId;
    
    private String questionType;
    
    private List<String> answer;

    
    
    
}
