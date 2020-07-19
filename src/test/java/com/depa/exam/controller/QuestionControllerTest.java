package com.depa.exam.controller;

import com.depa.category.model.Category;
import com.depa.category.service.CategoryService;
import com.depa.exam.dto.QuestionDTO;
import com.depa.exam.dto.impl.QuestionDTOImpl;
import com.depa.exam.model.question.SubjectiveQuestion;
import com.depa.exam.model.question.Question;
import com.depa.exam.service.QuestionService;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QuestionControllerTest {
    private Mockery mockery = new JUnit4Mockery();

    private QuestionController underTest;
    private QuestionService mockQuestionService;
    private CategoryService mockCategoryService;

    @BeforeEach
    void setUp() {
        underTest = new QuestionController();
        mockQuestionService = mockery.mock(QuestionService.class);
        mockCategoryService = mockery.mock(CategoryService.class);
        underTest.setQuestionService(mockQuestionService);
        underTest.setCategoryService(mockCategoryService);
    }

    @Test
    void testGetQuestionsShouldReturnListOfQuestionModel() {
        SubjectiveQuestion expectedQuestion = SubjectiveQuestion.create("1 + 1 = ?", null, new ArrayList<>());
        QuestionDTO expectedQuestionDTO = new QuestionDTOImpl(expectedQuestion);
        expectedGetQuestions(expectedQuestionDTO);

        ResponseEntity<List<QuestionDTO>> result = underTest.getQuestions();
        List<QuestionDTO> actualResult = result.getBody();

        Assert.assertThat(actualResult.size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualResult.get(0), CoreMatchers.equalTo(expectedQuestionDTO));
    }

    @Test
    void testCreateQuestion() {
        Category category = new Category("history", "#000000", "#ffffff");
        Question question = SubjectiveQuestion.create("1 + 1 = ?", null, Arrays.asList(category));
        QuestionDTOImpl request = new QuestionDTOImpl(question);

        expectedCreateQuestion(request, category);

        ResponseEntity<QuestionDTO> result = underTest.createQuestion(request);

        Assert.assertThat(result.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));
        Assert.assertThat(result.getBody(), CoreMatchers.equalTo(request));
    }

    private void expectedCreateQuestion(QuestionDTO request, Category category) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockQuestionService).createQuestion(request);
                will(returnValue(request));

                oneOf(mockCategoryService).createCategory(request.getCategories().get(0));
                will(returnValue(category));
            }
        });
    }

    private void expectedGetQuestions(QuestionDTO expectedQuestionDTO) {
        mockery.checking(new Expectations(){
            {
                oneOf(mockQuestionService).getQuestions();
                will(returnValue(Arrays.asList(expectedQuestionDTO)));
            }
        });
    }
}