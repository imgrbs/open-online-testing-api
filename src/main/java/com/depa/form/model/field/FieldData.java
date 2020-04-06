package com.depa.form.model.field;

import java.util.List;

public class FieldData {
    private String label;
    private int order;
    private boolean required;
    
    private String placeholder;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getLabel() {
        return label;
    }

    public int getOrder() {
        return order;
    }

    public boolean isRequired() {
        return required;
    }

    @Override
    public String toString() {
        return "FieldData{" +
                "label='" + label + '\'' +
                ", order=" + order +
                ", required=" + required +
                '}';
    }
}
