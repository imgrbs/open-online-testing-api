package com.depa.form.model.form;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.field.Field;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("forms")
@RequiredArgsConstructor
@Setter
@Getter
public class Form {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    
    private List<Field> fields;

    public Form(FormDTO formDTO) {
        this.name = formDTO.getName();
        this.description = formDTO.getDescription();
        this.fields = new ArrayList<>();

        if (formDTO.getFields() != null) {
            formDTO.getFields().forEach(fieldDTO -> {
                this.fields.add(fieldDTO.toField());
            });
        }
    }

    @Override
    public String toString() {
        return "Form{" + "id=" + id + ", name=" + name + ", description=" + description + ", fields=" + fields + '}';
    }

}
