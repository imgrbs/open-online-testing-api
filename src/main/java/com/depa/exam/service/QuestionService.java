package com.depa.exam.service;

import com.depa.exam.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getQuestions();

    QuestionDTO createQuestion(QuestionDTO question);
}
