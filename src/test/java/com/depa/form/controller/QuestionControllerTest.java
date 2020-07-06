package com.depa.form.controller;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.model.question.ChoiceQuestion;
import com.depa.form.model.question.Question;
import com.depa.form.model.question.TextQuestion;
import com.depa.form.service.QuestionService;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class QuestionControllerTest {
    private Mockery mockery = new JUnit4Mockery();
    private QuestionService mockQuestionService;

    @Test
    void shouldReturnAllAttributeWhenCreateChoiceQuestion() {
        QuestionController questionCtrl = new QuestionController();
        this.mockQuestionService = mockery.mock(QuestionService.class);
        questionCtrl.setQuestionService(mockQuestionService);

        Question choiceQuestion = new ChoiceQuestion<String>();
        choiceQuestion.setQuestionText("1 + 1 = ?");

        expectCreateQuestion(choiceQuestion);

        ResponseEntity<Question> actual = questionCtrl.createQuestion(choiceQuestion);
        Assert.assertTrue(actual.getBody() instanceof ChoiceQuestion);
    }

    private void expectCreateQuestion(Question expectedQuestion) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockQuestionService).createQuestion(expectedQuestion);
                will(returnValue(expectedQuestion));
            }
        });
    }

}
