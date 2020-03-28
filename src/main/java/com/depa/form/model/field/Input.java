package com.depa.form.model.field;

import java.util.List;

public class Input extends Field {

    private Input(FieldType type) {
        super(type);
    }

    public static Input create(FieldData fieldData, List<Attribute> attributes) {
        Input field = new Input(FieldType.INPUT);
        field.setFieldData(fieldData);
        field.setAttributes(attributes);
        return field;
    }

}
