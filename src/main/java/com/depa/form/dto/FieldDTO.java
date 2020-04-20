package com.depa.form.dto;

import com.depa.form.model.field.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class FieldDTO {
    private FieldType fieldType;
    private FieldData fieldData;
    private List<Attribute> attributes;
    private List<String> choiceList;

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

    public Field toField() {
        if (fieldType.equals(FieldType.TEXTAREA)) {
            return TextArea.create(fieldData, attributes);
        }

        if (fieldType.equals(FieldType.CHECKBOX)) {
            return Checkbox.create(fieldData, attributes, choiceList);
        }

        return Input.create(fieldData, attributes);
    }
}
