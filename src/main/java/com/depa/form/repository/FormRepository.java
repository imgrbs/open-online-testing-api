package com.depa.form.repository;

import com.depa.form.model.form.Form;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Test
 */
public interface FormRepository extends MongoRepository<Form, String>{
}
