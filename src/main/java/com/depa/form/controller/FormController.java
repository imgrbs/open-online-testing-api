package com.depa.form.controller;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/form")
    public Form createForm(@RequestBody FormDTO formDTO) {
        Form form = new Form(formDTO);
        Form responseForm = formService.createForm(form);
        return responseForm;
    }

    @GetMapping("/form/mock")
    public Form getForm() {
        Form responseForm = formService.mock();
        return responseForm;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }
}
