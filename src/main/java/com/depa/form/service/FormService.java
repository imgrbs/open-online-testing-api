package com.depa.form.service;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.repository.FormRepository;

public interface FormService {
    void setFormRepository(FormRepository mockFormRepository);

    Form createForm(Form form);

    FormDTO getForms();

    FormDTO getFormByUid();

    Form toForm(FormDTO formDTO);

    FormDTO toFormDTO(Form form);
}
