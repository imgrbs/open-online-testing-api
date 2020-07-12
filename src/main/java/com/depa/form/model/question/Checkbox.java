package com.depa.form.model.question;

import java.util.List;

public class Checkbox extends Question {

    private List<ChoiceList> choiceList ;

    public Checkbox(QuestionType questionType) {
        super(questionType);
    }

    public static Checkbox create(List<Attribute> attributes, List<ChoiceList> choiceList) {
        Checkbox field = new Checkbox(QuestionType.CHECKBOX);
        field.setAttributes(attributes);
        field.setChoiceList(choiceList);
        return field;
    }

    public List<ChoiceList> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<ChoiceList> choiceList) {
        this.choiceList = choiceList;
    }

    
}
