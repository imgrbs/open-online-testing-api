package com.depa.form.dto;

import com.depa.form.model.field.*;

import java.util.List;

public class FieldDTO {

    private FieldType fieldType;
    private FieldData fieldData;
    private List<Attribute> attributes;
    private List<ChoiceList> choiceList;

    public FieldDTO() {
    }

    public FieldDTO(Field field) {
        this.fieldType = field.getFieldType();
        this.fieldData = field.getFieldData();
        this.attributes = field.getAttributes();

        if (this.fieldType.equals(FieldType.CHECKBOX)) {
            this.choiceList = ((Checkbox) field).getChoiceList();
        }
    }

    public FieldDTO(FieldType fieldType, FieldData fieldData, List<Attribute> attributes, List<ChoiceList> choiceList) {
        this.fieldType = fieldType;
        this.fieldData = fieldData;
        this.attributes = attributes;
        this.choiceList = choiceList;
    }

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
    
    public List<ChoiceList> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<ChoiceList> choiceList) {
        this.choiceList = choiceList;
    }

    public Field toField() {
        if (fieldType.equals(FieldType.TEXTFIELD)) {
            return TextField.create(fieldData, attributes);
        }
        else if (fieldType.equals(FieldType.TEXTAREA)) {
            System.out.println(attributes);
            return TextArea.create(fieldData, attributes);
        }
        else if (fieldType.equals(FieldType.CHECKBOX)) {
            return Checkbox.create(fieldData, attributes, choiceList);
        }
        return Input.create(fieldData, attributes);
    }

    @Override
    public String toString() {
        return "FieldDTO{" + "fieldType=" + fieldType + ", fieldData=" + fieldData + ", attributes=" + attributes + ", choiceList=" + choiceList + '}';
    }

}
