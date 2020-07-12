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
        FieldDTO fieldDTO = new FieldDTO();

        Assert.assertThat(fieldDTO.getQuestionType(), CoreMatchers.nullValue());
        Assert.assertThat(fieldDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(fieldDTO.getChoiceList(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateFieldDTOWithField() {
        Question question = Checkbox.create(new ArrayList<>(), new ArrayList<>());
        FieldDTO fieldDTO = new FieldDTO(question);

        Assert.assertThat(fieldDTO.getQuestionType(), CoreMatchers.equalTo(QuestionType.CHECKBOX));
        Assert.assertThat(fieldDTO.getAttributes().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(fieldDTO.getChoiceList().size(), CoreMatchers.equalTo(0));
    }
}