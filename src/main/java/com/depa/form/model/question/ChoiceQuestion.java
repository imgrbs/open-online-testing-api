package com.depa.form.model.question;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChoiceQuestion<T> extends Question {
    private List<T> choices;

    public ChoiceQuestion() {
        super();
        this.type = QuestionType.CHOICE;
        this.choices = new ArrayList();
    }

    public void addChoice(T choice) {
        this.choices.add(choice);
    }
}
