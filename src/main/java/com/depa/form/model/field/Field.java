package com.depa.form.model.field;

import java.util.List;

public class Field {
    private FieldType fieldType;

    private FieldData fieldData;
    private List<Attribute> attributes;

    private Field() {
    }

    public Field(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public void setFieldData(FieldData fieldData) {
        this.fieldData = fieldData;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public FieldType getFieldType() {
        return this.fieldType;
    }

    public FieldData getFieldData() {
        return this.fieldData;
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }
}
