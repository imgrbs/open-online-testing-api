package com.depa.form.dto;

import com.depa.form.model.question.Checkbox;
import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class QuestionDTOTest {

    @Test
    public void testCreateFieldDTO() {
        QuestionDTO questionDTO = new QuestionDTO();

        Assert.assertThat(questionDTO.getQuestionType(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoiceList(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateFieldDTOWithField() {
        Question question = Checkbox.create(new ArrayList<>(), new ArrayList<>());
        QuestionDTO questionDTO = new QuestionDTO(question);

        Assert.assertThat(questionDTO.getQuestionType(), CoreMatchers.equalTo(QuestionType.CHECKBOX));
        Assert.assertThat(questionDTO.getAttributes().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(questionDTO.getChoiceList().size(), CoreMatchers.equalTo(0));
    }
}