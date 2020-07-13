package com.depa.exam.dto;

import com.depa.exam.dto.impl.QuestionDTOImpl;
import com.depa.exam.model.question.ObjectiveQuestion;
import com.depa.exam.model.question.Question;
import com.depa.exam.model.question.QuestionType;
import com.depa.exam.model.question.SubjectiveQuestion;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class QuestionDTOImplTest {

    @Test
    public void testCreateQuestionDTO() {
        QuestionDTOImpl questionDTO = new QuestionDTOImpl();

        Assert.assertThat(questionDTO.getType(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateObjectiveQuestionDTO() {
        Question question = ObjectiveQuestion.create(null, new ArrayList<>());

        QuestionDTO questionDTO = new QuestionDTOImpl(question);

        Assert.assertThat(questionDTO.getType(), CoreMatchers.equalTo(QuestionType.OBJECTIVE));
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices().size(), CoreMatchers.equalTo(0));
    }

    @Test
    void testCreateSubjectiveQuestionDTO() {
        Question question = SubjectiveQuestion.create("1 + 1 = ?", null);

        QuestionDTO questionDTO = new QuestionDTOImpl(question);

        Assert.assertThat(questionDTO.getType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices(), CoreMatchers.nullValue());
    }
}