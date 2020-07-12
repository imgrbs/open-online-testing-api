package com.depa.form.dto;

import com.depa.form.model.question.ObjectiveQuestion;
import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import com.depa.form.model.question.SubjectiveQuestion;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class QuestionDTOTest {

    @Test
    public void testCreateQuestionDTO() {
        QuestionDTO questionDTO = new QuestionDTO();

        Assert.assertThat(questionDTO.getQuestionType(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateObjectiveQuestionDTO() {
        Question question = ObjectiveQuestion.create(null, new ArrayList<>());

        QuestionDTO questionDTO = new QuestionDTO(question);

        Assert.assertThat(questionDTO.getQuestionType(), CoreMatchers.equalTo(QuestionType.OBJECTIVE));
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices().size(), CoreMatchers.equalTo(0));
    }

    @Test
    void testCreateSubjectiveQuestionDTO() {
        Question question = SubjectiveQuestion.create("1 + 1 = ?", null);

        QuestionDTO questionDTO = new QuestionDTO(question);

        Assert.assertThat(questionDTO.getQuestionType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices(), CoreMatchers.nullValue());
    }
}