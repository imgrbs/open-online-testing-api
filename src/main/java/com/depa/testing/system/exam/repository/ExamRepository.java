package com.depa.testing.system.exam.repository;

import com.depa.testing.system.exam.model.exam.Exam;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends MongoRepository<Exam, ObjectId>{
}
