package com.depa.form.model.question;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum QuestionType {
    @JsonProperty("text")
    TEXT,
    @JsonProperty("choice")
    CHOICE
}
