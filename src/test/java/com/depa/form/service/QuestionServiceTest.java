package com.depa.form.service;

import com.depa.form.dto.QuestionDTO;
import com.depa.form.model.question.SubjectiveQuestion;
import com.depa.form.repository.QuestionRepository;
import com.depa.form.service.internal.QuestionServiceImpl;
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
        mockery.checking(new Expectations(){
            {
                oneOf(questionRepository).findAll();
                will(returnValue(Arrays.asList(question)));
            }
        });

        List<QuestionDTO> actualResult = underTest.getQuestions();

        Assert.assertThat(actualResult.size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualResult.get(0).getName(), CoreMatchers.equalTo(question.getName()));
        Assert.assertThat(actualResult.get(0).getAttributes(), CoreMatchers.equalTo(question.getAttributes()));
        Assert.assertThat(actualResult.get(0).getQuestionType(), CoreMatchers.equalTo(question.getType()));
    }
}