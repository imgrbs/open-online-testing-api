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
import java.util.List;

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

    @Test
    void testGetForms() {
        Form form1 = new Form();
        Form form2 = new Form();
        Form form3 = new Form();

        List<Form> expectedForms = new ArrayList<>();
        expectedForms.add(form1);
        expectedForms.add(form2);
        expectedForms.add(form3);

        expectedGetForms(form1, form2, form3, expectedForms);

        List<FormDTO> actualForms = underTest.getForms();

        Assert.assertThat(actualForms.size(), CoreMatchers.equalTo(3));
    }

    private void expectedGetForms(Form form1, Form form2, Form form3, List<Form> expectedForms) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockFormService).getForms();
                will(returnValue(expectedForms));

                oneOf(mockFormService).toFormDTO(form1);
                will(returnValue(new FormDTO(form1)));

                oneOf(mockFormService).toFormDTO(form2);
                will(returnValue(new FormDTO(form2)));

                oneOf(mockFormService).toFormDTO(form3);
                will(returnValue(new FormDTO(form3)));

                oneOf(mockFormService).getForms();
                will(returnValue(expectedForms));
            }
        });
    }

    @Test
    void testGetFormByUid() {
        String uid = "16092526-7741-11ea-bc55-0242ac130003";
        Form expectedForm = new Form();
        FormDTO expectedFormDTO = new FormDTO(expectedForm);

        mockery.checking(new Expectations() {
            {
                oneOf(mockFormService).getFormByUid(uid);
                will(returnValue(expectedForm));

                oneOf(mockFormService).toFormDTO(expectedForm);
                will(returnValue(expectedFormDTO));
            }
        });

        FormDTO actualForm = underTest.getFormByUid(uid);

        Assert.assertThat(expectedFormDTO.getName(), CoreMatchers.equalTo(actualForm.getName()));
        Assert.assertThat(expectedFormDTO.getDescription(), CoreMatchers.equalTo(actualForm.getDescription()));
        Assert.assertThat(expectedFormDTO.getFields(), CoreMatchers.equalTo(actualForm.getFields()));
    }
}