package com.depa.exam.dto;

import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.model.exam.Exam;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ExamDTOTest {

    @Test
    public void testCreateFormDTO() {
        ExamDTO underTest = new ExamDTOImpl();

        Assert.assertThat(underTest.getName(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getDescription(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getQuestions(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateFormDTOWithForm() {
        Exam exam = new Exam();
        ExamDTO underTest = new ExamDTOImpl(exam);

        Assert.assertThat(underTest.getName(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getDescription(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getQuestions().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(underTest.getCategories().size(), CoreMatchers.equalTo(0));
    }

    @Test
    void testToExam() {
        Exam exam = new Exam("5f03163c00657756d47d0884", "exam name", "exam description", new ArrayList<>(), new ArrayList<>());
        ExamDTOImpl underTest = new ExamDTOImpl(exam);

        Exam actual = underTest.toExam();

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo(exam.getName()));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo(exam.getDescription()));
        Assert.assertThat(actual.getQuestions().size(), CoreMatchers.equalTo(0));
    }
}
