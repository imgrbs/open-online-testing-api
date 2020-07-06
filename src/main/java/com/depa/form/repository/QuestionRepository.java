package com.depa.form.repository;

import com.depa.form.model.question.Question;

public interface QuestionRepository {
    Question save(Question question);
}
