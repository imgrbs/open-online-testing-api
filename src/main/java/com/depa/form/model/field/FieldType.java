package com.depa.form.model.field;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FieldType {
    @JsonProperty("input")
    INPUT,
    @JsonProperty("textfield")
    TEXTFIELD,
    @JsonProperty(value = "textarea")
    TEXTAREA,
    @JsonProperty("number")
    NUMBER,
    @JsonProperty("select")
    CHECKBOX,
    @JsonProperty(value = "radio")
    RADIO,
 
}
