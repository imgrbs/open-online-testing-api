package com.depa.form.service;

import com.depa.form.model.question.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);

    List<Question> getQuestions();
}
