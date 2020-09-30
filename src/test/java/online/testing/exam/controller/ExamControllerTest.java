package online.testing.exam.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import online.testing.exam.dto.CategoryDTO;
import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.dto.impl.ExamDTOImpl;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.service.CategoryService;
import online.testing.exam.service.ExamService;

class ExamControllerTest {
    public static final String RAW_ID = "5f03163c00657756d47d0884";
    private final Mockery mockery = new JUnit4Mockery();
    private ExamController underTest;
    private ExamService mockExamService;
    private CategoryService mockCategoryService;

    @BeforeEach
    void setUp() {
        underTest = new ExamController();
        mockExamService = mockery.mock(ExamService.class);
        underTest.setExamService(mockExamService);
        mockCategoryService = mockery.mock(CategoryService.class);
        underTest.setCategoryService(mockCategoryService);
    }

    @Test
    void testCreateExam() {
        CategoryDTOImpl categoryDTO = createCategoryDTO();
        Exam exam = createExam(Arrays.asList(categoryDTO));
        ExamDTOImpl examDTO = createExamDTO(exam);
        expectCreateExam(examDTO, categoryDTO);

        ResponseEntity<ExamDTO> actual = underTest.createExam(examDTO);

        Assert.assertThat(actual.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));

        ExamDTO actualExam = actual.getBody();

        Assert.assertThat(actualExam.getName(), CoreMatchers.equalTo("Exam Set 1"));
        Assert.assertThat(actualExam.getDescription(), CoreMatchers.equalTo("Set A"));
        Assert.assertThat(actualExam.getQuestions().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(actualExam.getCategories().size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualExam.getCategories().get(0), CoreMatchers.equalTo(categoryDTO));
    }

    private CategoryDTOImpl createCategoryDTO() {
        CategoryDTOImpl categoryDTO = new CategoryDTOImpl();
        categoryDTO.setId(RAW_ID);
        categoryDTO.setLabel("history");
        categoryDTO.setBackgroundColor("#000000");
        categoryDTO.setColor("#ffffff");
        return categoryDTO;
    }

    private Exam createExam(List<CategoryDTOImpl> categories) {
        Exam e = new Exam();
        e.setId(RAW_ID);
        e.setName("Exam Set 1");
        e.setDescription("Set A");
        e.setQuestions(new ArrayList<>());
        e.setCategories(categories);
        return e;
    }

    private ExamDTOImpl createExamDTO(Exam exam) {
        ExamDTOImpl examDTO = new ExamDTOImpl(exam);
        return examDTO;
    }

    private void expectCreateExam(ExamDTO expectedExam, CategoryDTO categoryDTO) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).createExam(expectedExam);
                will(returnValue(expectedExam));

                allowing(mockCategoryService).createCategory(categoryDTO);
                will(returnValue(categoryDTO));

            }
        });
    }

    @Test
    void testGetExams() {
        Exam exam = createExam(new ArrayList<>());
        List<ExamDTO> expectedExams = new ArrayList<>();
        expectedExams.add(createExamDTO(exam));

        expectedGetExams(expectedExams, exam);

        ResponseEntity<List<ExamDTO>> actualExam = underTest.getExams();

        Assert.assertThat(actualExam.getStatusCode(), CoreMatchers.equalTo(HttpStatus.OK));
        Assert.assertThat(actualExam.getBody().size(), CoreMatchers.equalTo(1));
        Assert.assertThat(actualExam.getBody().get(0).getName(), CoreMatchers.equalTo(exam.getName()));
        Assert.assertThat(actualExam.getBody().get(0).getDescription(), CoreMatchers.equalTo(exam.getDescription()));
        Assert.assertThat(actualExam.getBody().get(0).getQuestions().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(actualExam.getBody().get(0).getCategories().size(), CoreMatchers.equalTo(0));
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
        Exam expectedExam = createExam(new ArrayList<>());
        ExamDTO expectedExamDTO = createExamDTO(expectedExam);

        expectGenerateExam(expectedExam, expectedExamDTO);

        ResponseEntity<ExamDTO> actual = underTest.getExamDetailById(expectedExam.getId());

        ExamDTO actualExam = actual.getBody();

        Assert.assertThat(expectedExamDTO.getName(), CoreMatchers.equalTo(actualExam.getName()));
        Assert.assertThat(expectedExamDTO.getDescription(), CoreMatchers.equalTo(actualExam.getDescription()));
        Assert.assertThat(expectedExamDTO.getQuestions(), CoreMatchers.equalTo(actualExam.getQuestions()));
        Assert.assertThat(expectedExamDTO.getCategories(), CoreMatchers.equalTo(actualExam.getQuestions()));
    }

    private void expectGenerateExam(Exam expectedExam, ExamDTO expectedExamDTO) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockExamService).generateExamination(expectedExam.getId());
                will(returnValue(expectedExamDTO));
            }
        });
    }
}
