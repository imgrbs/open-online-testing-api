package com.depa.form.model;

import com.depa.form.model.field.Field;
import com.depa.form.model.field.FieldType;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldTest {

    private Field underTest;

    @BeforeEach
    void setUp() {
//        underTest = new Field(FieldType.INPUT);
    }

    @Test
    public void testField() {
        Assert.assertThat(underTest.getFieldType(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getFieldData(), CoreMatchers.equalTo(null));
        Assert.assertThat(underTest.getAttributes(), CoreMatchers.equalTo(null));
    }
}