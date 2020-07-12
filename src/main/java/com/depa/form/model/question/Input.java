package com.depa.form.model.question;

import java.util.List;

public class Input extends Question {

    private Input(QuestionType type) {
        super(type);
    }

    public static Input create(String name, List<Attribute> attributes) {
        Input question = new Input(QuestionType.INPUT);
        question.setName(name);
        question.setAttributes(attributes);
        return question;
    }

}
