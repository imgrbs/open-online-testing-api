package com.depa.form.model;

import com.depa.form.model.question.ChoiceQuestion;
import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChoiceQuestionTest {

    @Test
    public void shouldAbleToAddChoice() {
        int expectedChoicesSize = 2;

        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.addChoice("choice 1");
        choiceQuestion.addChoice("choice 2");

        Assert.assertEquals(expectedChoicesSize, choiceQuestion.getChoices().size());
    }

    @Test
    public void shouldReturnTrueWhenAnswerIsCorrect() {
        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setQuestionText("1 + 1 = ?");
        choiceQuestion.addChoice("1");
        choiceQuestion.addChoice("2");
        choiceQuestion.addCorrectChoicePosition(1);

        List<String> answers = new ArrayList<>();
        answers.add("2");
        Boolean actual = choiceQuestion.isCorrectAnswers(answers);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueWhenAllAnswerIsCorrect() {
        String correctAnswer1 = "ถูก";
        String correctAnswer2 = "ถูกอีกแล้ว";

        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setQuestionText("ข้อใดถูกต้อง?");
        choiceQuestion.addChoice(correctAnswer1);
        choiceQuestion.addChoice("ไม่่ถูก");
        choiceQuestion.addChoice(correctAnswer2);
        choiceQuestion.addCorrectChoicePosition(0);
        choiceQuestion.addCorrectChoicePosition(2);

        List<String> answers = new ArrayList<>();
        answers.add(correctAnswer2);
        answers.add(correctAnswer1);
        Boolean actual = choiceQuestion.isCorrectAnswers(answers);

        Assert.assertTrue(actual);
    }
}
