package com.depa.form.model.field;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class TextField extends Field {

    private TextField(FieldType type) {
        super(type);
    }

    public static TextField create(FieldData fieldData, List<Attribute> attributes) {
        TextField field = new TextField(FieldType.TEXTFIELD);
        return field;
    }

}
