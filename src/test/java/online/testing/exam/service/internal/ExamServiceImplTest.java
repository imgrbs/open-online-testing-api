package online.testing.exam.service.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import online.testing.exam.dto.ExamDTO;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.repository.ExamRepository;
import online.testing.user.dto.UserPrincipal;
import online.testing.user.model.user.User;

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
        User user = createUser();
        UserPrincipal userPrincipal = UserPrincipal.create(user, Map.of());

        Exam exam = createExam();
        exam.setOwnerId(userPrincipal.getId());
        ExamDTO examDTO = mockery.mock(ExamDTO.class);
        expectedToExam(examDTO, exam);
        expectedSaveExam(exam);

        ExamDTO actual = underTest.createExam(examDTO, userPrincipal.getId());

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo("Interview 2020"));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo("Interviewing new jobbers."));
        Assert.assertThat(actual.getQuestions().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(actual.getCategories().size(), CoreMatchers.equalTo(0));
    }

    private User createUser() {
        User user = mockery.mock(User.class);
        mockery.checking(new Expectations() {
            {
                oneOf(user).getId();
                will(returnValue("xxx"));
                oneOf(user).getEmail();
                will(returnValue("depa@gmail.com"));
                oneOf(user).getPassword();
                will(returnValue("xxx"));
                oneOf(user).getAttributes();
                will(returnValue(Map.of()));
            }
        });
        return user;
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
        String id = RAW_ID;
        Exam expectedExam = createExam();

        expectedGetFormByUid(id, expectedExam);

        ExamDTO actualExam = underTest.getExamById(id);

        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo(expectedExam.getName()));
        Assert.assertThat(actualExam.getDescription(), CoreMatchers.equalTo(expectedExam.getDescription()));
        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo(expectedExam.getName()));
        Assert.assertThat(actualExam.getCategories().size(), CoreMatchers.equalTo(0));
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
    void testGetExams() {
        User user = createUser();
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        Exam exam = createExam();
        List<Exam> expectedExams = new ArrayList<>();
        expectedExams.add(exam);
        expectFindByUserId(userPrincipal, expectedExams);

        List<ExamDTO> actualExams = underTest.getExams(userPrincipal.getId());

        Assert.assertThat(actualExams.size(), CoreMatchers.equalTo(expectedExams.size()));
        Assert.assertThat(actualExams.get(0).getName(), CoreMatchers.equalTo(exam.getName()));
        Assert.assertThat(actualExams.get(0).getDescription(), CoreMatchers.equalTo(exam.getDescription()));
        Assert.assertThat(actualExams.get(0).getQuestions().size(), CoreMatchers.equalTo(exam.getQuestions().size()));
        Assert.assertThat(actualExams.get(0).getCategories().size(), CoreMatchers.equalTo(0));
    }

    private void expectFindByUserId(UserPrincipal userPrincipal, List<Exam> expectedExams) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamRepository).findByOwnerId(userPrincipal.getId());
                will(returnValue(expectedExams));
            }
        });
    }
}