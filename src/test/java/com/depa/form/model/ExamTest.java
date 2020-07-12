package com.depa.form.model;

import com.depa.form.dto.QuestionDTO;
import com.depa.form.dto.impl.QuestionDTOImpl;
import com.depa.form.dto.ExamDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.model.question.QuestionType;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExamTest {

    @Test
    void testCreateExam() {
        Exam underTest = new Exam();

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getQuestions(), CoreMatchers.equalTo(null));
    }

    @Test
    public void testCreateExamWithExamDTO() {
        List<QuestionDTO> questions = new ArrayList<>();
        QuestionDTOImpl input = new QuestionDTOImpl();
        input.setType(QuestionType.SUBJECTIVE);
        questions.add(input);
        ExamDTO examDTO = new ExamDTO();
        examDTO.setFields(questions);

        Exam underTest = new Exam(examDTO);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getQuestions().size(), CoreMatchers.equalTo(1));
    }
}