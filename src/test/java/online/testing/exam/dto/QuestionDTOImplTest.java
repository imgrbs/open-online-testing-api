package online.testing.exam.dto;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.model.question.ObjectiveQuestion;
import online.testing.exam.model.question.Question;
import online.testing.exam.model.question.QuestionType;
import online.testing.exam.model.question.SubjectiveQuestion;

class QuestionDTOImplTest {

    @Test
    public void testCreateQuestionDTO() {
        QuestionDTOImpl questionDTO = new QuestionDTOImpl();

        Assert.assertThat(questionDTO.getType(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateObjectiveQuestionDTO() {
        Question question = ObjectiveQuestion.create("1 + 1 = ?", new ArrayList<>(), new ArrayList<>() , new ArrayList<>());

        QuestionDTO questionDTO = new QuestionDTOImpl(question);

        Assert.assertThat(questionDTO.getType(), CoreMatchers.equalTo(QuestionType.OBJECTIVE));
        Assert.assertThat(questionDTO.getAttributes().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(questionDTO.getChoices().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(questionDTO.getCategories().size(), CoreMatchers.equalTo(0));
    }

    @Test
    void testCreateSubjectiveQuestionDTO() {
        Question question = SubjectiveQuestion.create("1 + 1 = ?", null, new ArrayList<>());

        QuestionDTO questionDTO = new QuestionDTOImpl(question);

        Assert.assertThat(questionDTO.getType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(questionDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getChoices(), CoreMatchers.nullValue());
        Assert.assertThat(questionDTO.getCategories().size(), CoreMatchers.equalTo(0));
    }
}