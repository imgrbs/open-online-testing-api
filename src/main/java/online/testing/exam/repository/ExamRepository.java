package online.testing.exam.repository;

import online.testing.exam.model.exam.Exam;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends MongoRepository<Exam, String> {
}
