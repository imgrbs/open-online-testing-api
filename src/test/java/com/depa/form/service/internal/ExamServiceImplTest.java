package com.depa.form.service.internal;

import com.depa.form.model.exam.Exam;
import com.depa.form.repository.ExamRepository;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ExamServiceImplTest {
    private Mockery mockery = new JUnit4Mockery();

    private ExamServiceImpl underTest;
    private ExamRepository mockExamRepository;

    @BeforeEach
    public void setUp() {
        underTest = new ExamServiceImpl();
        mockExamRepository = mockery.mock(ExamRepository.class);
        underTest.setExamRepository(mockExamRepository);
    }

    @Test
    public void testCreateForm() {
        Exam exam = createForm();

        expectedSaveForm(exam);

        Exam actual = underTest.createForm(exam);

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo("Interview 2020"));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo("Interviewing new jobbers."));
        Assert.assertThat(actual.getQuestions().size(), CoreMatchers.equalTo(0));
    }

    private Exam createForm() {
        Exam exam = new Exam();
        exam.setName("Interview 2020");
        exam.setDescription("Interviewing new jobbers.");
        exam.setQuestions(new ArrayList<>());
        return exam;
    }

    private void expectedSaveForm(Exam exam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamRepository).save(exam);
                will(returnValue(exam));
            }
        });
    }

    @Test
    void testGetFormById() {
        String uid = "16092526-7741-11ea-bc55-0242ac130003";
        Exam expectedExam = createForm();

        expectedGetFormByUid(uid, expectedExam);

        Exam actualExam = underTest.getFormById(uid);

        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo(expectedExam.getName()));
        Assert.assertThat(actualExam.getDescription(), CoreMatchers.equalTo(expectedExam.getDescription()));
        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo(expectedExam.getName()));
    }

    private void expectedGetFormByUid(String id, Exam expectedExam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamRepository).findById(id);
                will(returnValue(Optional.of(expectedExam)));
            }
        });
    }

    @Test
    void testGetForms() {
        Exam exam = createForm();
        List<Exam> expectedExams = new ArrayList<>();
        expectedExams.add(exam);

        expectFindAll(expectedExams);

        List<Exam> actualExams = underTest.getForms();

        Assert.assertThat(actualExams.size(), CoreMatchers.equalTo(expectedExams.size()));
        Assert.assertThat(actualExams.get(0), CoreMatchers.equalTo(expectedExams.get(0)));
    }

    private void expectFindAll(List<Exam> expectedExams) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamRepository).findAll();
                will(returnValue(expectedExams));
            }
        });
    }
}