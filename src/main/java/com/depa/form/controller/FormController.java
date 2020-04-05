package com.depa.form.controller;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/form")
    public FormDTO createForm(@RequestBody FormDTO formDTO) {
        Form form = formService.toForm(formDTO);
        Form responseForm = formService.createForm(form);
        return formService.toFormDTO(responseForm);
    }


    @GetMapping("/forms")
    public List<FormDTO> getForms() {
        List<Form> forms = formService.getForms();

        List<FormDTO> responseForms = new ArrayList<>();
        forms.forEach(form -> {
            responseForms.add(formService.toFormDTO(form));
        });

        return responseForms;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }
}
