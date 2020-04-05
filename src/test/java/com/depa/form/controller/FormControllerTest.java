package com.depa.form.controller;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.service.FormService;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FormControllerTest {
    private Mockery mockery = new JUnit4Mockery();

    private FormController underTest;
    private FormService mockFormService;

    @BeforeEach
    void setUp() {
        underTest = new FormController();
        mockFormService = mockery.mock(FormService.class);
        underTest.setFormService(mockFormService);
    }

    @Test
    void testCreateForm() {
        Form form = createForm();
        FormDTO formDTO = createFormDto();
        expectCreateForm(formDTO, form);

        FormDTO actual = underTest.createForm(formDTO);

        Assert.assertThat(actual.getName(), CoreMatchers.equalTo("Interview 2020"));
        Assert.assertThat(actual.getDescription(), CoreMatchers.equalTo("Interviewing new jobbers."));
        Assert.assertThat(actual.getFields().size(), CoreMatchers.equalTo(0));
    }

    private Form createForm() {
        Form form = new Form();
        form.setName("Interview 2020");
        form.setDescription("Interviewing new jobbers.");
        form.setFields(new ArrayList<>());
        return form;
    }

    private FormDTO createFormDto() {
        FormDTO formDTO = new FormDTO();
        formDTO.setName("Interview 2020");
        formDTO.setDescription("Interviewing new jobbers.");
        formDTO.setFields(new ArrayList<>());
        return formDTO;
    }

    private void expectCreateForm(FormDTO expectedDTO, Form expectedForm) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockFormService).toForm(expectedDTO);
                will(returnValue(expectedForm));

                oneOf(mockFormService).createForm(expectedForm);
                will(returnValue(expectedForm));

                oneOf(mockFormService).toFormDTO(expectedForm);
                will(returnValue(expectedDTO));
            }
        });
    }
}