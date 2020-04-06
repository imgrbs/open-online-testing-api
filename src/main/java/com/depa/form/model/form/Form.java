package com.depa.form.model.form;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.field.Field;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("forms")
public class Form {
    
    @Id
    private String id;
    private String uid;
    private String name;
    private String description;
    
    private List<Field> fields;

    public Form(FormDTO formDTO) {
        this.name = formDTO.getName();
        this.description = formDTO.getDescription();
        this.fields = new ArrayList<>();

        if (formDTO.getFields() != null) {
            System.out.println("Field != null");
            formDTO.getFields().forEach(fieldDTO -> {
                System.out.println(fieldDTO);
                this.fields.add(fieldDTO.toField());
            });
        }
    }

    public Form() {
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Field> getFields() {
        return this.fields;
    }

    @Override
    public String toString() {
        return "Form{" + "id=" + id + ", uid=" + uid + ", name=" + name + ", description=" + description + ", fields=" + fields + '}';
    }

}
