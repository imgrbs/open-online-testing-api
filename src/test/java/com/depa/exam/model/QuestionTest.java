package com.depa.exam.model;

import com.depa.exam.model.question.ObjectiveQuestion;
import com.depa.exam.model.question.Question;
import com.depa.exam.model.question.QuestionType;
import com.depa.exam.model.question.SubjectiveQuestion;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class QuestionTest {

    @Test
    public void testSubjectiveQuestion() {
        Question underTest = SubjectiveQuestion.create("input question", null);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo("input question"));
        Assert.assertThat(underTest.getType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(underTest.getAttributes(), CoreMatchers.nullValue());
    }

    @Test
    public void testObjectiveQuestion() {
        ObjectiveQuestion underTest = ObjectiveQuestion.create("input question", new ArrayList<>(), null);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo("input question"));
        Assert.assertThat(underTest.getType(), CoreMatchers.equalTo(QuestionType.OBJECTIVE));
        Assert.assertThat(underTest.getChoices().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(underTest.getAttributes(), CoreMatchers.nullValue());
    }
}