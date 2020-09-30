package online.testing.exam.controller;

import online.testing.exam.dto.CategoryDTO;
import online.testing.exam.dto.QuestionDTO;
import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.model.question.Question;
import online.testing.exam.model.question.SubjectiveQuestion;
import online.testing.exam.service.CategoryService;
import online.testing.exam.service.QuestionService;
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
    private final Mockery mockery = new JUnit4Mockery();

    private QuestionController underTest;
    private QuestionService mockQuestionService;
    private CategoryService mockCategoryService;

    @BeforeEach
    void setUp() {
        underTest = new QuestionController();
        mockQuestionService = mockery.mock(QuestionService.class);
        underTest.setQuestionService(mockQuestionService);
        mockCategoryService = mockery.mock(CategoryService.class);
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
        CategoryDTOImpl categoryDTO = createCategoryDTO();
        Question question = SubjectiveQuestion.create("1 + 1 = ?", null, Arrays.asList(categoryDTO));
        QuestionDTOImpl request = new QuestionDTOImpl(question);
        expectedCreateQuestion(request, categoryDTO);

        ResponseEntity<QuestionDTO> result = underTest.createQuestion(request);

        mockery.assertIsSatisfied();
        Assert.assertThat(result.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));
        Assert.assertThat(result.getBody(), CoreMatchers.equalTo(request));
    }

    private CategoryDTOImpl createCategoryDTO() {
        CategoryDTOImpl categoryDTO = new CategoryDTOImpl();
        categoryDTO.setLabel("history");
        categoryDTO.setBackgroundColor("#000000");
        categoryDTO.setColor("#ffffff");
        return categoryDTO;
    }

    private void expectedCreateQuestion(QuestionDTO request, CategoryDTO categoryDTO) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockQuestionService).createQuestion(request);
                will(returnValue(request));

                oneOf(mockCategoryService).createCategory(categoryDTO);
                will(returnValue(categoryDTO));
            }
        });
    }

    private void expectedGetQuestions(QuestionDTO expectedQuestionDTO) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockQuestionService).getQuestions();
                will(returnValue(Arrays.asList(expectedQuestionDTO)));
            }
        });
    }

}
