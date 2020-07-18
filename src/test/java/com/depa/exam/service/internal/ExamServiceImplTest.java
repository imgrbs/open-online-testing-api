package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamDTO;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.repository.ExamRepository;
import org.bson.types.ObjectId;
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
    public static final String RAW_ID = "5f03163c00657756d47d0884";

    @BeforeEach
    public void setUp() {
        underTest = new ExamServiceImpl();
        mockExamRepository = mockery.mock(ExamRepository.class);
        underTest.setExamRepository(mockExamRepository);
    }

    @Test
    public void testCreateExam() {
        Exam exam = createExam();
        ExamDTO examDTO = mockery.mock(ExamDTO.class);
        expectedToExam(examDTO, exam);
        expectedSaveExam(exam);

        ExamDTO actual = underTest.createExam(examDTO);

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo("Interview 2020"));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo("Interviewing new jobbers."));
        Assert.assertThat(actual.getQuestions().size(), CoreMatchers.equalTo(0));
    }

    private void expectedToExam(ExamDTO examDTO, Exam exam) {
        mockery.checking(new Expectations() {
            {
                oneOf(examDTO).toExam();
                will(returnValue(exam));
            }
        });
    }

    private Exam createExam() {
        Exam exam = new Exam();
        exam.setName("Interview 2020");
        exam.setDescription("Interviewing new jobbers.");
        exam.setQuestions(new ArrayList<>());
        return exam;
    }

    private void expectedSaveExam(Exam exam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamRepository).save(exam);
                will(returnValue(exam));
            }
        });
    }

    @Test
    void testGetExamByObjectId() {
        ObjectId id = new ObjectId(RAW_ID);
        Exam expectedExam = createExam();

        expectedGetFormByUid(id, expectedExam);

        ExamDTO actualExam = underTest.getExamById(id);

        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo(expectedExam.getName()));
        Assert.assertThat(actualExam.getDescription(), CoreMatchers.equalTo(expectedExam.getDescription()));
        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo(expectedExam.getName()));
    }

    private void expectedGetFormByUid(ObjectId id, Exam expectedExam) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamRepository).findById(id);
                will(returnValue(Optional.of(expectedExam)));
            }
        });
    }

    @Test
    void testGetExams() {
        Exam exam = createExam();
        List<Exam> expectedExams = new ArrayList<>();
        expectedExams.add(exam);
        expectFindAll(expectedExams);

        List<ExamDTO> actualExams = underTest.getExams();

        Assert.assertThat(actualExams.size(), CoreMatchers.equalTo(expectedExams.size()));
        Assert.assertThat(actualExams.get(0).getName(), CoreMatchers.equalTo(exam.getName()));
        Assert.assertThat(actualExams.get(0).getDescription(), CoreMatchers.equalTo(exam.getDescription()));
        Assert.assertThat(actualExams.get(0).getQuestions().size(), CoreMatchers.equalTo(exam.getQuestions().size()));
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