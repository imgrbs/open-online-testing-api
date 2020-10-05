package online.testing.exam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import online.testing.exam.model.exam.Exam;

@Repository
public interface ExamRepository extends MongoRepository<Exam, String> {
	List<Exam> findByOwnerId(String userId);
}
