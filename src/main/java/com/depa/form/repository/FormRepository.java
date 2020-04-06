/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.repository;

import com.depa.form.model.form.Form;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Test
 */
@Repository
public interface FormRepository extends MongoRepository<Form, String>{

    Form findByUid(String uid);
    
}
