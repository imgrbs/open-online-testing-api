package com.depa.form.model;

import com.depa.form.dto.FieldDTO;
import com.depa.form.dto.FormDTO;
import com.depa.form.model.field.Field;
import com.depa.form.model.field.FieldType;
import com.depa.form.model.field.Input;
import com.depa.form.model.form.Form;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

class FormTest {

    @Test
    void testCreateForm() {
        Form underTest = new Form();

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getFields(), CoreMatchers.equalTo(null));
    }

    @Test
    public void testCreateFormWithFormDTO() {
        List<FieldDTO> fields = new ArrayList<>();
        FieldDTO input = new FieldDTO();
        input.setFieldType(FieldType.INPUT);
        fields.add(input);
        FormDTO formDTO = new FormDTO();
        formDTO.setFields(fields);

        Form underTest = new Form(formDTO);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getDescription(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getFields().size(), CoreMatchers.equalTo(1));
    }
}