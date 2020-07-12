package com.depa.form.controller;

import com.depa.form.dto.ExamDTO;
import com.depa.form.model.exam.Exam;
import com.depa.form.service.ExamService;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExamControllerTest {
    private Mockery mockery = new JUnit4Mockery();

    private ExamController underTest;
    private ExamService mockExamService;

    @BeforeEach
    void setUp() {
        underTest = new ExamController();
        mockExamService = mockery.mock(ExamService.class);
        underTest.setExamService(mockExamService);
    }

    @Test
    void testCreateForm() {
        Exam exam = createForm();
        ExamDTO examDTO = createFormDto();
        expectCreateForm(examDTO, exam);

        ExamDTO actual = underTest.createExam(examDTO);

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo("Interview 2020"));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo("Interviewing new jobbers."));
        Assert.assertThat(actual.getFields().size(), CoreMatchers.equalTo(0));
    }

    private Exam createForm() {
        Exam exam = new Exam();
        exam.setName("Interview 2020");
        exam.setDescription("Interviewing new jobbers.");
        exam.setQuestions(new ArrayList<>());
        return exam;
    }

    private ExamDTO createFormDto() {
        ExamDTO examDTO = new ExamDTO();
        examDTO.setName("Interview 2020");
        examDTO.setDescription("Interviewing new jobbers.");
        examDTO.setFields(new ArrayList<>());
        return examDTO;
    }

    private void expectCreateForm(ExamDTO expectedDTO, Exam expectedExam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).toForm(expectedDTO);
                will(returnValue(expectedExam));

                oneOf(mockExamService).createForm(expectedExam);
                will(returnValue(expectedExam));

                oneOf(mockExamService).toFormDTO(expectedExam);
                will(returnValue(expectedDTO));
            }
        });
    }

    @Test
    void testGetForms() {
        Exam exam1 = new Exam();
        Exam exam2 = new Exam();
        Exam exam3 = new Exam();

        List<Exam> expectedExams = new ArrayList<>();
        expectedExams.add(exam1);
        expectedExams.add(exam2);
        expectedExams.add(exam3);

        expectedGetForms(exam1, exam2, exam3, expectedExams);

        List<ExamDTO> actualForms = underTest.getExams();

        Assert.assertThat(actualForms.size(), CoreMatchers.equalTo(3));
    }

    private void expectedGetForms(Exam exam1, Exam exam2, Exam exam3, List<Exam> expectedExams) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).getForms();
                will(returnValue(expectedExams));

                oneOf(mockExamService).toFormDTO(exam1);
                will(returnValue(new ExamDTO(exam1)));

                oneOf(mockExamService).toFormDTO(exam2);
                will(returnValue(new ExamDTO(exam2)));

                oneOf(mockExamService).toFormDTO(exam3);
                will(returnValue(new ExamDTO(exam3)));

                oneOf(mockExamService).getForms();
                will(returnValue(expectedExams));
            }
        });
    }

    @Test
    void testGetFormByUid() {
        String uid = "16092526-7741-11ea-bc55-0242ac130003";
        Exam expectedExam = new Exam();
        ExamDTO expectedExamDTO = new ExamDTO(expectedExam);

        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).getFormById(uid);
                will(returnValue(expectedExam));

                oneOf(mockExamService).toFormDTO(expectedExam);
                will(returnValue(expectedExamDTO));
            }
        });

        ExamDTO actualForm = underTest.getExamByUid(uid);

        Assert.assertThat(expectedExamDTO.getName(), CoreMatchers.equalTo(actualForm.getName()));
        Assert.assertThat(expectedExamDTO.getDescription(), CoreMatchers.equalTo(actualForm.getDescription()));
        Assert.assertThat(expectedExamDTO.getFields(), CoreMatchers.equalTo(actualForm.getFields()));
    }
}