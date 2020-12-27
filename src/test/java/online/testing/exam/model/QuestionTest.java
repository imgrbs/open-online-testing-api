package online.testing.exam.model;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import online.testing.exam.model.question.ObjectiveQuestion;
import online.testing.exam.model.question.Question;
import online.testing.exam.model.question.QuestionType;
import online.testing.exam.model.question.SubjectiveQuestion;

class QuestionTest {

    @Test
    public void testSubjectiveQuestion() {
        Question underTest = SubjectiveQuestion.create("input question", null, new ArrayList<>());

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo("input question"));
        Assert.assertThat(underTest.getType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(underTest.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getCategories().size(), CoreMatchers.equalTo(0));
    }

    @Test
    public void testObjectiveQuestion() {
        ObjectiveQuestion underTest = ObjectiveQuestion.create("input question", new ArrayList<>(), new ArrayList<>() ,new ArrayList<>());

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo("input question"));
        Assert.assertThat(underTest.getType(), CoreMatchers.equalTo(QuestionType.OBJECTIVE));
        Assert.assertThat(underTest.getChoices().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(underTest.getAttributes().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(underTest.getCategories().size(), CoreMatchers.equalTo(0));
    }
}