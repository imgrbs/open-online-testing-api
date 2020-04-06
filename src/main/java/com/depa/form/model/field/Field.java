package com.depa.form.model.field;

import java.util.List;
import org.springframework.data.annotation.Id;


public abstract class Field {
    
    @Id
    private long fieldId;
    
    private FieldType fieldType;

    private FieldData fieldData;
    
    private List<Attribute> attributes;

    private Field() {
    }

    public Field(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
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

    @Override
    public String toString() {
        return "Field{" + "fieldId=" + fieldId + ", fieldType=" + fieldType + ", fieldData=" + fieldData + ", attributes=" + attributes + '}';
    }
    
}
