package com.depa.testing.system.exam.controller;

import com.depa.testing.system.exam.dto.ExamDTO;
import com.depa.testing.system.exam.dto.impl.ExamDTOImpl;
import com.depa.testing.system.exam.model.exam.Exam;
import com.depa.testing.system.exam.service.ExamService;
import org.bson.types.ObjectId;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

class ExamControllerTest {
    private Mockery mockery = new JUnit4Mockery();

    private ExamController underTest;
    private ExamService mockExamService;
    public static final String RAW_ID = "5f03163c00657756d47d0884";

    @BeforeEach
    void setUp() {
        underTest = new ExamController();
        mockExamService = mockery.mock(ExamService.class);
        underTest.setExamService(mockExamService);
    }

    @Test
    void testCreateExam() {
        Exam exam = createExam();
        ExamDTOImpl examDTO = createExamDTO(exam);
        expectCreateExam(examDTO);

        ResponseEntity<ExamDTO> actual = underTest.createExam(examDTO);

        Assert.assertThat(actual.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));

        ExamDTO actalExam = actual.getBody();
        Assert.assertThat(actalExam.getName(), CoreMatchers.equalTo("Exam Set 1"));
        Assert.assertThat(actalExam.getDescription(), CoreMatchers.equalTo("Set A"));
        Assert.assertThat(actalExam.getQuestions().size(), CoreMatchers.equalTo(0));
    }

    private Exam createExam() {
        return new Exam(new ObjectId(RAW_ID), "Exam Set 1", "Set A", new ArrayList<>());
    }

    private ExamDTOImpl createExamDTO(Exam exam) {
        ExamDTOImpl examDTO = new ExamDTOImpl(exam);
        return examDTO;
    }

    private void expectCreateExam(ExamDTO expectedExam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).createExam(expectedExam);
                will(returnValue(expectedExam));
            }
        });
    }

    @Test
    void testGetExams() {
        Exam exam = createExam();
        List<ExamDTO> expectedExams = new ArrayList<>();
        expectedExams.add(createExamDTO(exam));

        expectedGetExams(expectedExams, exam);

        ResponseEntity<List<ExamDTO>> actualExam = underTest.getExams();

        Assert.assertThat(actualExam.getStatusCode(), CoreMatchers.equalTo(HttpStatus.OK));
        Assert.assertThat(actualExam.getBody().size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualExam.getBody().get(0).getName(), CoreMatchers.equalTo(exam.getName()));
        Assert.assertThat(actualExam.getBody().get(0).getDescription(), CoreMatchers.equalTo(exam.getDescription()));
        Assert.assertThat(actualExam.getBody().get(0).getQuestions().size(), CoreMatchers.equalTo(0));
    }

    private void expectedGetExams(List<ExamDTO> expectedExams, Exam exam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).getExams();
                will(returnValue(expectedExams));

                oneOf(mockExamService).toExamDTO(exam);
                will(returnValue(new ExamDTOImpl(exam)));

                oneOf(mockExamService).getExams();
                will(returnValue(expectedExams));
            }
        });
    }

    @Test
    void testGetExamByObjectId() {
        Exam expectedExam = createExam();
        ExamDTO expectedExamDTO = createExamDTO(expectedExam);

        expectedGetExamById(expectedExam.getId(), expectedExamDTO);
        expectedToExamDTO(expectedExam, expectedExamDTO);

        ResponseEntity<ExamDTO> actual = underTest.getExamByObjectId(expectedExam.getId());

        ExamDTO actualExam = actual.getBody();

        Assert.assertThat(expectedExamDTO.getName(), CoreMatchers.equalTo(actualExam.getName()));
        Assert.assertThat(expectedExamDTO.getDescription(), CoreMatchers.equalTo(actualExam.getDescription()));
        Assert.assertThat(expectedExamDTO.getQuestions(), CoreMatchers.equalTo(actualExam.getQuestions()));
    }

    private void expectedToExamDTO(Exam expectedExam, ExamDTO expectedExamDTO) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).toExamDTO(expectedExam);
                will(returnValue(expectedExamDTO));
            }
        });
    }

    private void expectedGetExamById(ObjectId id, ExamDTO expectedExam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).getExamById(id);
                will(returnValue(expectedExam));
            }
        });
    }
}