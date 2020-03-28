package com.depa.form.dto;

import com.depa.form.model.field.*;

import java.util.List;

public class FieldDTO {
    private FieldType fieldType;
    private FieldData fieldData;
    private List<Attribute> attributes;
    private List<String> choiceList;

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public FieldData getFieldData() {
        return fieldData;
    }

    public void setFieldData(FieldData fieldData) {
        this.fieldData = fieldData;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        this.choiceList = choiceList;
    }

    public Field toField() {
        if (fieldType.equals(FieldType.TEXTFIELD)) {
            return TextField.create(fieldData, attributes);
        }

        if (fieldType.equals(FieldType.CHECKBOX)) {
            return Checkbox.create(fieldData, attributes, choiceList);
        }

        return Input.create(fieldData, attributes);
    }
}
