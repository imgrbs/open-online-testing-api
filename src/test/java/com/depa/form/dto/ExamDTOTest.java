package com.depa.form.dto;

import com.depa.form.model.exam.Exam;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ExamDTOTest {

    @Test
    public void testCreateFormDTO() {
        ExamDTO underTest = new ExamDTO();

        Assert.assertThat(underTest.getName(),CoreMatchers.nullValue());
        Assert.assertThat(underTest.getDescription(),CoreMatchers.nullValue());
        Assert.assertThat(underTest.getFields(),CoreMatchers.nullValue());
    }

    @Test
    void testCreateFormDTOWithForm() {
        Exam exam = new Exam();
        ExamDTO underTest = new ExamDTO(exam);

        Assert.assertThat(underTest.getName(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getDescription(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getFields().size(), CoreMatchers.equalTo(0));
    }
}