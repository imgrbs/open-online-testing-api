package com.depa.testing.system.exam.service;

import com.depa.testing.system.exam.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getQuestions();

    QuestionDTO createQuestion(QuestionDTO question);
}
