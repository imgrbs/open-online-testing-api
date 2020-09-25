/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.repository;

import com.depa.exam.model.answer.ExamAnswer;
import com.depa.exam.model.exam.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Test
 */
public interface ExamAnswerRepository extends MongoRepository<ExamAnswer, String>{
    
}
