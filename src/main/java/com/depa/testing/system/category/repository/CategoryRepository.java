package com.depa.testing.system.category.repository;

import com.depa.testing.system.category.model.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository  extends MongoRepository<Category, ObjectId> {
    Optional<Category> findByLabel(String label);
}
