package com.depa.form.service;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.repository.FormRepository;

import java.util.List;

public interface FormService {
    void setFormRepository(FormRepository mockFormRepository);

    Form createForm(Form form);

    List<Form> getForms();

    Form getFormById(String uid);

    Form toForm(FormDTO formDTO);

    FormDTO toFormDTO(Form form);
}
