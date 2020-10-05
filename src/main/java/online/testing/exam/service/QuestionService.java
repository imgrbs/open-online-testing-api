package online.testing.exam.service;

import java.util.List;

import online.testing.exam.dto.QuestionDTO;

public interface QuestionService {

    List<QuestionDTO> getQuestions();

    QuestionDTO createQuestion(QuestionDTO question);

    List<QuestionDTO> getQuestionsByUserId(String userId);
}
