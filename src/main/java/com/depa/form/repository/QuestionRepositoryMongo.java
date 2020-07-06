package com.depa.form.repository;

import com.depa.form.model.question.Question;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepositoryMongo implements QuestionRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Question save(Question question) {
        return mongoTemplate.save(question);
    }
}
