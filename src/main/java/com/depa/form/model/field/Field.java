package com.depa.form.model.field;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Field {
    
    @Id
    private long fieldId;
    
    @Embedded
    private FieldType fieldType;

    @Embedded
    private FieldData fieldData;
    
    @OneToMany
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
}
