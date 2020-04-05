package com.depa.form.service.internal;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.repository.FormRepository;
import com.depa.form.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public void setFormRepository(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public Form createForm(Form form) {
        return formRepository.save(form);
    }

    @Override
    public List<Form> getForms() {
        return this.formRepository.findAll();
    }

    @Override
    public FormDTO getFormByUid() {
        return null;
    }

    @Override
    public Form toForm(FormDTO formDTO) {
        return new Form(formDTO);
    }

    @Override
    public FormDTO toFormDTO(Form form) {
        return new FormDTO(form);
    }
}
