package online.testing.exam.service.internal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import online.testing.exam.dto.QuestionDTO;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.model.question.Question;
import online.testing.exam.repository.QuestionRepository;
import online.testing.exam.service.QuestionService;

@Setter
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDTO> getQuestions() {
        List<QuestionDTO> questions = new ArrayList<>();
        questionRepository.findAll().forEach(question -> questions.add(new QuestionDTOImpl(question)));
        return questions;
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question = questionRepository.save(questionDTO.toQuestion());
        return new QuestionDTOImpl(question);
    }

    @Override
    public List<QuestionDTO> getQuestionsByUserId(String userId) {
        List<Question> questions = questionRepository.findByUserId(userId);

        if (questions.size() == 0) {
            return null;
        }

        List<QuestionDTO> dto = new ArrayList<>();
        for (Question question : questions) {
            dto.add(new QuestionDTOImpl(question));
        }
        return dto;
    }

}
