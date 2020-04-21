package com.depa.form.service.internal;

import com.depa.form.model.form.Form;
import com.depa.form.repository.FormRepository;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class FormServiceImplTest {
    private Mockery mockery = new JUnit4Mockery();

    private FormServiceImpl underTest;
    private FormRepository mockFormRepository;

    @BeforeEach
    public void setUp() {
        underTest = new FormServiceImpl();
        mockFormRepository = mockery.mock(FormRepository.class);
        underTest.setFormRepository(mockFormRepository);
    }

    @Test
    public void testCreateForm() {
        Form form = createForm();

        expectedSaveForm(form);

        Form actual = underTest.createForm(form);

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

    private void expectedSaveForm(Form form) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockFormRepository).save(form);
                will(returnValue(form));
            }
        });
    }

    @Test
    void testGetFormById() {
        String uid = "16092526-7741-11ea-bc55-0242ac130003";
        Form expectedForm = createForm();

        expectedGetFormByUid(uid, expectedForm);

        Form actualForm = underTest.getFormById(uid);

        Assert.assertThat(actualForm.getName(), CoreMatchers.equalTo(expectedForm.getName()));
        Assert.assertThat(actualForm.getDescription(), CoreMatchers.equalTo(expectedForm.getDescription()));
        Assert.assertThat(actualForm.getName(), CoreMatchers.equalTo(expectedForm.getName()));
    }

    private void expectedGetFormByUid(String id, Form expectedForm) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockFormRepository).findById(id);
                will(returnValue(Optional.of(expectedForm)));
            }
        });
    }

    @Test
    void testGetForms() {
        Form form = createForm();
        List<Form> expectedForms = new ArrayList<>();
        expectedForms.add(form);

        expectFindAll(expectedForms);

        List<Form> actualForms = underTest.getForms();

        Assert.assertThat(actualForms.size(), CoreMatchers.equalTo(expectedForms.size()));
        Assert.assertThat(actualForms.get(0), CoreMatchers.equalTo(expectedForms.get(0)));
    }

    private void expectFindAll(List<Form> expectedForms) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockFormRepository).findAll();
                will(returnValue(expectedForms));
            }
        });
    }
}