package com.depa.form.service.internal;

import ch.qos.logback.core.BasicStatusManager;
import com.depa.form.dto.FormDTO;
import com.depa.form.dto.QuestionDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.model.question.Question;
import com.depa.form.repository.QuestionRepository;
import com.depa.form.service.QuestionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Setter
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDTO> getQuestions() {
        List<QuestionDTO> questions = new ArrayList<>();
        questionRepository.findAll().forEach(question -> questions.add(new QuestionDTO(question)));
        return questions;
    }
}
