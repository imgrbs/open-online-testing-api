package com.depa.form.service.internal;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.repository.FormRepository;
import com.depa.form.service.FormService;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}