package com.depa.form.model.question;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChoiceQuestion<T> extends Question {
    private List<T> choices;
    private List<Integer> correctChoicePositions;

    public ChoiceQuestion() {
        super();
        this.type = QuestionType.CHOICE;
        this.choices = new ArrayList();
        this.correctChoicePositions = new ArrayList<>();
    }

    public void addChoice(T choice) {
        this.choices.add(choice);
    }

    public void addCorrectChoicePosition(int index) {
        this.correctChoicePositions.add(index);
    }

    public Boolean isCorrectAnswers(List<T> answers) {
        List<T> correctAnswers = new ArrayList<>();
        for (Integer index : correctChoicePositions) {
            correctAnswers.add(this.choices.get(index));
        }
        return correctAnswers.containsAll(answers) && answers.containsAll(correctAnswers);
    }
}
