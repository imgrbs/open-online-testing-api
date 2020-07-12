package com.depa.form.model.question;

import java.util.List;

public class ObjectiveQuestion extends Question {

    private List<Choice> choices;

    public ObjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static ObjectiveQuestion create(List<Attribute> attributes, List<Choice> choices) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setAttributes(attributes);
        field.setChoices(choices);
        return field;
    }

    public static ObjectiveQuestion create(String name, List<Choice> choices, List<Attribute> attributes) {
        ObjectiveQuestion question = create(attributes, choices);
        question.setName(name);
        return question;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    
}
