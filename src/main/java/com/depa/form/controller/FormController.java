package com.depa.form.controller;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.service.FormService;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    @Setter(AccessLevel.PROTECTED)
    private FormService formService;

    @PostMapping("/form")
    public FormDTO createForm(@RequestBody FormDTO formDTO) {
        Form form = formService.toForm(formDTO);
        System.out.println("CAsting workkk !!!!!");
        System.out.println(form);
        Form responseForm = formService.createForm(form);
        System.out.println("Response From Create Form Work !!!!!!!!!!!!!!!!!!");
        System.out.println(responseForm);
        return formService.toFormDTO(responseForm);
    }

    @GetMapping("/form/{uid}")
    public FormDTO getFormByUid(@PathVariable String uid) {
        Form responseForm = formService.getFormById(uid);
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

}
