package com.depa.form.model.question;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveQuestion extends Question {

    private List<ChoiceList> choices;

    public ObjectiveQuestion(QuestionType questionType) {
        super(questionType);
    }

    public static ObjectiveQuestion create(List<Attribute> attributes, List<ChoiceList> choices) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setAttributes(attributes);
        field.setChoices(choices);
        return field;
    }

    public static ObjectiveQuestion create(String name, List<ChoiceList> choices, List<Attribute> attributes) {
        ObjectiveQuestion question = create(attributes, choices);
        question.setName(name);
        return question;
    }

    public List<ChoiceList> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceList> choices) {
        this.choices = choices;
    }

    
}
