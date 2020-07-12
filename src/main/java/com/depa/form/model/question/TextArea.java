/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.question;

import java.util.List;

/**
 *
 * @author Test
 */
public class TextArea extends Question {

    private TextArea(QuestionType type) {
        super(type);
    }

    public static TextArea create(List<Attribute> attributes) {
        TextArea field = new TextArea(QuestionType.TEXTAREA);
        field.setAttributes(attributes);
        return field;
    }
}
