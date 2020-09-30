package online.testing.exam.model;

import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.dto.impl.ExamDTOImpl;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.model.question.QuestionType;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExamTest {

    @Test
    void testCreateExam() {
        Exam underTest = new Exam();

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getQuestions(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getCategories().size(), CoreMatchers.equalTo(0));
    }

    @Test
    public void testCreateExamWithExamDTO() {
        List<QuestionDTOImpl> questions = createQuestions();
        List<CategoryDTOImpl> categories = Arrays.asList(new CategoryDTOImpl());

        ExamDTO examDTO = new ExamDTOImpl();
        examDTO.setQuestions(questions);
        examDTO.setCategories(categories);

        Exam underTest = new Exam(examDTO);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getQuestions().size(), CoreMatchers.equalTo(2));
        Assert.assertThat(underTest.getQuestions().get(0).getType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(underTest.getQuestions().get(1).getType(), CoreMatchers.equalTo(QuestionType.OBJECTIVE));
        Assert.assertThat(underTest.getCategories().size(), CoreMatchers.equalTo(1));
    }

    private List<QuestionDTOImpl> createQuestions() {
        List<QuestionDTOImpl> questions = new ArrayList<>();
        QuestionDTOImpl question1 = createQuestion(QuestionType.SUBJECTIVE);
        QuestionDTOImpl question2 = createQuestion(QuestionType.OBJECTIVE);
        questions.add(question1);
        questions.add(question2);
        return questions;
    }

    private QuestionDTOImpl createQuestion(QuestionType type) {
        QuestionDTOImpl question = new QuestionDTOImpl();
        question.setType(type);
        return question;
    }
}