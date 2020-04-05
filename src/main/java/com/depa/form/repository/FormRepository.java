package com.depa.form.repository;

import com.depa.form.model.form.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, String> {
    Form save(Form form);
}
