package com.depa.form.model;

import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import com.depa.form.model.question.TextQuestion;
import org.junit.Assert;
import org.junit.Test;

public class QuestionTest {
    @Test
    public void shouldAbleToCreateQuestionTextType() {
        Question textQuestion = new TextQuestion();

        Assert.assertEquals(QuestionType.TEXT, textQuestion.getType());
    }

}
