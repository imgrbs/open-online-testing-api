package com.depa.form.model.field;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FieldType {
    @JsonProperty("input")
    INPUT,
    @JsonProperty("textfield")
    TEXTFIELD,
    @JsonProperty("number")
    NUMBER,
    @JsonProperty("checkbox")
    CHECKBOX,
    @JsonProperty(value = "select")
    RADIO,
 
}
