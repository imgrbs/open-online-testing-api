package com.depa.form.service.internal;

import com.depa.form.model.field.Field;
import com.depa.form.model.field.Input;
import com.depa.form.model.field.TextField;
import com.depa.form.model.form.Form;
import com.depa.form.service.FormService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Override
    public Form createForm(Form form) {
        System.out.println("===============");
        System.out.println("FormServiceImpl");
        System.out.println("===============");
        System.out.println(form.getName());
        System.out.println(form.getDescription());
        System.out.println(form.getFields().get(0).getFieldType());
        System.out.println(form.getFields().get(0).getFieldData().toString());
        System.out.println(form.getFields().get(0).getAttributes());
        return form;
    }

    public Form mock() {
        Form form = null;
//        Form form = new Form();
//        List<Field> fields = new ArrayList<Field>();
//
////        fields.add(new Input());
////        fields.add(new TextField());
////        fields.add(new Field());
//        fields.add(Input.create(fieldData, attributes));
//        Field field = Input.create(fieldData, attributes);
//        fields.add(TextField.create(fieldData, attributes));
//
////        Field input = new Input();
////        input.setType(Radio);
//
//        form.setFields(fields);
        return form;
    }
}
