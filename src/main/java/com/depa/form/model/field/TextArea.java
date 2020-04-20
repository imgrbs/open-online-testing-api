package com.depa.form.model.field;

import java.util.List;

public class TextArea extends Field {

    private TextArea(FieldType type) {
        super(type);
    }

    public static TextArea create(FieldData fieldData, List<Attribute> attributes) {
        TextArea field = new TextArea(FieldType.TEXTAREA);
        return field;
    }

}
