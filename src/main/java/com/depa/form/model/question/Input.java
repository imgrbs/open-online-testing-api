package com.depa.form.model.question;

import java.util.List;

public class Input extends Question {

    private Input(QuestionType type) {
        super(type);
    }

    public static Input create(List<Attribute> attributes) {
        Input field = new Input(QuestionType.INPUT);
        field.setAttributes(attributes);
        return field;
    }

}
