package com.depa.form.service;

import com.depa.form.model.form.Form;

public interface FormService {
    Form createForm(Form form);

    Form mock();
}
