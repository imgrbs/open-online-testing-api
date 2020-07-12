package com.depa.form.model.question;

import java.util.List;

public class TextQuestion extends Question {

    private TextQuestion(QuestionType type) {
        super(type);
    }

    public static TextQuestion create(List<Attribute> attributes) {
        TextQuestion field = new TextQuestion(QuestionType.TEXTFIELD);
        return field;
    }

}
