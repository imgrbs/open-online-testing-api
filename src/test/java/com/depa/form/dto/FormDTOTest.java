package com.depa.form.dto;

import com.depa.form.model.form.Form;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormDTOTest {

    @Test
    public void testCreateFormDTO() {
        FormDTO underTest = new FormDTO();

        Assert.assertThat(underTest.getName(),CoreMatchers.nullValue());
        Assert.assertThat(underTest.getDescription(),CoreMatchers.nullValue());
        Assert.assertThat(underTest.getFields(),CoreMatchers.nullValue());
    }

    @Test
    void testCreateFormDTOWithForm() {
        Form form = new Form();
        FormDTO underTest = new FormDTO(form);

        Assert.assertThat(underTest.getName(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getDescription(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getFields().size(), CoreMatchers.equalTo(0));
    }
}