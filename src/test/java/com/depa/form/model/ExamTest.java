package com.depa.form.model;

import com.depa.form.dto.FieldDTO;
import com.depa.form.dto.FormDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.model.question.QuestionType;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExamTest {

    @Test
    void testCreateForm() {
        Exam underTest = new Exam();

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getQuestions(), CoreMatchers.equalTo(null));
    }

    @Test
    public void testCreateFormWithFormDTO() {
        List<FieldDTO> fields = new ArrayList<>();
        FieldDTO input = new FieldDTO();
        input.setQuestionType(QuestionType.INPUT);
        fields.add(input);
        FormDTO formDTO = new FormDTO();
        formDTO.setFields(fields);

        Exam underTest = new Exam(formDTO);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getQuestions().size(), CoreMatchers.equalTo(1));
    }
}