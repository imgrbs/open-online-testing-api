package com.depa.form.dto;

import com.depa.form.model.question.Question;

public interface QuestionDTO {

    Question toQuestion();

    void setName(String name);

    void setType(com.depa.form.model.question.QuestionType type);

    void setAttributes(java.util.List<com.depa.form.model.question.Attribute> attributes);

    void setChoices(java.util.List<com.depa.form.model.question.Choice> choices);

    String getName();

    com.depa.form.model.question.QuestionType getType();

    java.util.List<com.depa.form.model.question.Attribute> getAttributes();

    java.util.List<com.depa.form.model.question.Choice> getChoices();

}
