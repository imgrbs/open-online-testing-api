package com.depa.form.model.field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public abstract class Field {
    
    @Id
    private long fieldId;
    
    private FieldType fieldType;

    private FieldData fieldData;
    
    private List<Attribute> attributes;

    private Field() {
    }

    public Field(FieldType type) {
        this.fieldType = type;
    }

    @Override
    public String toString() {
        return "Field{" + "fieldId=" + fieldId + ", fieldType=" + fieldType + ", fieldData=" + fieldData + ", attributes=" + attributes + '}';
    }
    
}
