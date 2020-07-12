package com.depa.form.model.question;

import java.util.List;

public class ObjectiveQuestion extends Question {

    private List<ChoiceList> choices;

    public ObjectiveQuestion(QuestionType questionType) {
        super(questionType);
    }

    public static ObjectiveQuestion create(List<Attribute> attributes, List<ChoiceList> choiceList) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setAttributes(attributes);
        field.setChoices(choiceList);
        return field;
    }

    public List<ChoiceList> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceList> choices) {
        this.choices = choices;
    }

    
}
