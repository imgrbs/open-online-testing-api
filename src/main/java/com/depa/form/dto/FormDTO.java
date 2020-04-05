package com.depa.form.dto;

import com.depa.form.model.form.Form;

import java.util.ArrayList;
import java.util.List;

public class FormDTO {
    private String name;
    private String description;
    private List<FieldDTO> fields;

    public FormDTO() {
    }

    public FormDTO(Form form) {
        this.name = form.getName();
        this.description = form.getDescription();
        this.fields = new ArrayList<>();

        if (form.getFields() != null) {
            form.getFields().forEach(field -> {
                this.fields.add(new FieldDTO(field));
            });
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDTO> fields) {
        this.fields = fields;
    }

}
