package online.testing.exam.service;

import online.testing.exam.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getQuestions();

    QuestionDTO createQuestion(QuestionDTO question);
}
