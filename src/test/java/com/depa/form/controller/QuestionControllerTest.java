package com.depa.form.controller;

import com.depa.form.dto.QuestionDTO;
import com.depa.form.model.question.Input;
import com.depa.form.model.question.Question;
import com.depa.form.service.QuestionService;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionControllerTest {

    private Mockery mockery = new JUnit4Mockery();

    private QuestionController underTest;
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        underTest = new QuestionController();
        questionService = mockery.mock(QuestionService.class);
        underTest.setQuestionService(questionService);
    }

    @Test
    void testGetQuestionsShouldReturnListOfQuestionModel() {
        Input expectedQuestion = Input.create("1 + 1 = ?", null);
        QuestionDTO expectedQuestionDTO = new QuestionDTO(expectedQuestion);
        expectedGetQuestions(expectedQuestionDTO);

        ResponseEntity<List<QuestionDTO>> result = underTest.getQuestions();
        List<QuestionDTO> actualResult = result.getBody();

        Assert.assertThat(actualResult.size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualResult.get(0), CoreMatchers.equalTo(expectedQuestionDTO));
    }

    private void expectedGetQuestions(QuestionDTO expectedQuestionDTO) {
        mockery.checking(new Expectations(){
            {
                oneOf(questionService).getQuestions();
                will(returnValue(Arrays.asList(expectedQuestionDTO)));
            }
        });
    }
}