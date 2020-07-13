package com.depa.exam.service;

import com.depa.exam.dto.QuestionDTO;
import com.depa.exam.model.question.Choice;
import com.depa.exam.model.question.ObjectiveQuestion;
import com.depa.exam.model.question.SubjectiveQuestion;
import com.depa.exam.repository.QuestionRepository;
import com.depa.exam.service.internal.QuestionServiceImpl;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class QuestionServiceTest {
    private JUnit4Mockery mockery = new JUnit4Mockery();

    private QuestionServiceImpl underTest;
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        underTest = new QuestionServiceImpl();
        questionRepository = mockery.mock(QuestionRepository.class);
        underTest.setQuestionRepository(questionRepository);
    }

    @Test
    public void testGetQuestions() {
        SubjectiveQuestion question = SubjectiveQuestion.create("1 + 1 = ?", null);
        expectedFindAllQuestions(question);

        List<QuestionDTO> actualResult = underTest.getQuestions();

        Assert.assertThat(actualResult.size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualResult.get(0).getName(), CoreMatchers.equalTo(question.getName()));
        Assert.assertThat(actualResult.get(0).getAttributes(), CoreMatchers.equalTo(question.getAttributes()));
        Assert.assertThat(actualResult.get(0).getType(), CoreMatchers.equalTo(question.getType()));
    }

    private void expectedFindAllQuestions(SubjectiveQuestion question) {
        mockery.checking(new Expectations() {
            {
                oneOf(questionRepository).findAll();
                will(returnValue(Arrays.asList(question)));
            }
        });
    }

    @Test
    void testCreateQuestion() {
        Choice choice1 = new Choice("2", true);
        Choice choice2 = new Choice("3", false);
        ObjectiveQuestion question = ObjectiveQuestion.create("1 + 1 = ?", Arrays.asList(choice1, choice2), null);
        QuestionDTO mockQuestionDTO = createQuestionDTO(question);
        expectedSaveQuestion(question);

        QuestionDTO result = underTest.createQuestion(mockQuestionDTO);

        Assert.assertThat(result.getName(), CoreMatchers.equalTo(question.getName()));
        Assert.assertThat(result.getType(), CoreMatchers.equalTo(question.getType()));
        Assert.assertThat(result.getChoices().size(), CoreMatchers.equalTo(2));
        Assert.assertThat(result.getChoices().get(0), CoreMatchers.equalTo(choice1));
        Assert.assertThat(result.getChoices().get(1), CoreMatchers.equalTo(choice2));
        Assert.assertThat(result.getAttributes(), CoreMatchers.nullValue());
    }

    private void expectedSaveQuestion(ObjectiveQuestion question) {
        mockery.checking(new Expectations() {
            {
                oneOf(questionRepository).save(question);
                will(returnValue(question));
            }
        });
    }

    private QuestionDTO createQuestionDTO(ObjectiveQuestion question) {
        QuestionDTO dto = mockery.mock(QuestionDTO.class);

        mockery.checking(new Expectations() {
            {
                oneOf(dto).toQuestion();
                will(returnValue(question));
            }
        });
        return dto;
    }
}