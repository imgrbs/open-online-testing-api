/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.testing.exam.repository;

import online.testing.exam.model.answer.ExamAnswer;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Test
 */
public interface ExamAnswerRepository extends MongoRepository<ExamAnswer, String>{
    
}
