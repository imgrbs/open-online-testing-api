package com.depa.form.repository;

import com.depa.form.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryMongo implements QuestionRepository {
    public static final String COLLECTION_NAME = "questions";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Question save(Question question) {
        return mongoTemplate.save(question, COLLECTION_NAME);
    }

    @Override
    public List<Question> findAll() {
        return mongoTemplate.findAll(Question.class, COLLECTION_NAME);
    }
}
