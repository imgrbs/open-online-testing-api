package com.depa.form.repository;

import com.depa.form.model.question.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findAll();
}
