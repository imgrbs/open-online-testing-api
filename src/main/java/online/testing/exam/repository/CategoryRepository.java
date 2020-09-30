package online.testing.exam.repository;

import online.testing.exam.model.category.Category;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByLabel(String label);
}
