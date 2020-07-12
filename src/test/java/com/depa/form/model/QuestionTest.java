package com.depa.form.model;

import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import com.depa.form.model.question.Input;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionTest {

    private Question underTest;

    @BeforeEach
    void setUp() {
        underTest = Input.create(null);
    }

    @Test
    public void testField() {
        Assert.assertThat(underTest.getQuestionType(), CoreMatchers.equalTo(QuestionType.INPUT));
        Assert.assertThat(underTest.getAttributes(), CoreMatchers.equalTo(null));
    }
}