package online.testing.exam.dto;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import online.testing.exam.dto.impl.ExamDTOImpl;
import online.testing.exam.model.exam.Exam;

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
        Exam exam = new Exam();
        exam.setName("EXAM NAME");
        exam.setDescription("DESCRIPTION");
        exam.setQuestions(new ArrayList<>());
        ExamDTOImpl underTest = new ExamDTOImpl(exam);

        Exam actual = underTest.toExam();

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo(exam.getName()));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo(exam.getDescription()));
        Assert.assertThat(actual.getQuestions().size(), CoreMatchers.equalTo(0));
    }
}
