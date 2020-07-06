package com.depa.form.model.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TextQuestion.class, name = "text"),
    @JsonSubTypes.Type(value = ChoiceQuestion.class, name = "choice"),
})
public abstract class Question {
    @Id
    private String id;
    protected QuestionType type;
    protected String questionText;
}
