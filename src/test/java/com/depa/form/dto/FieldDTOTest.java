package com.depa.form.dto;

import com.depa.form.model.field.Checkbox;
import com.depa.form.model.field.Field;
import com.depa.form.model.field.FieldData;
import com.depa.form.model.field.FieldType;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class FieldDTOTest {

    @Test
    public void testCreateFieldDTO() {
        FieldDTO fieldDTO = new FieldDTO();

        Assert.assertThat(fieldDTO.getFieldType(), CoreMatchers.nullValue());
        Assert.assertThat(fieldDTO.getFieldData(), CoreMatchers.nullValue());
        Assert.assertThat(fieldDTO.getAttributes(), CoreMatchers.nullValue());
        Assert.assertThat(fieldDTO.getChoiceList(), CoreMatchers.nullValue());
    }

    @Test
    void testCreateFieldDTOWithField() {
        FieldData fieldData = new FieldData();
        Field field = Checkbox.create(fieldData, new ArrayList<>(), new ArrayList<>());
        FieldDTO fieldDTO = new FieldDTO(field);

        Assert.assertThat(fieldDTO.getFieldType(), CoreMatchers.equalTo(FieldType.CHECKBOX));
        Assert.assertThat(fieldDTO.getFieldData(), CoreMatchers.equalTo(fieldData));
        Assert.assertThat(fieldDTO.getAttributes().size(), CoreMatchers.equalTo(0));
        Assert.assertThat(fieldDTO.getChoiceList().size(), CoreMatchers.equalTo(0));
    }
}