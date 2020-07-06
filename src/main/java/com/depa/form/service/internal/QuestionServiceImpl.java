package com.depa.form.service.internal;

import com.depa.form.model.question.Question;
import com.depa.form.repository.QuestionRepository;
import com.depa.form.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
}
