package online.testing.exam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import online.testing.exam.model.question.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
	List<Question> findByUserId(String userId);
}
