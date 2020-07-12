package com.depa.form.repository;

import com.depa.form.model.exam.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepository extends MongoRepository<Exam, String>{
}
