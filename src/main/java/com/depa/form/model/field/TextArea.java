/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.field;

import java.util.List;

/**
 *
 * @author Test
 */
public class TextArea extends Field {

    private TextArea(FieldType type) {
        super(type);
    }

    public static TextArea create(FieldData fieldData, List<Attribute> attributes) {
        TextArea field = new TextArea(FieldType.TEXTAREA);
        field.setFieldData(fieldData);
        field.setAttributes(attributes);
        return field;
    }
}
