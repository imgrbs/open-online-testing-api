package com.depa.form.dto;

import com.depa.form.model.question.Attribute;
import com.depa.form.model.question.Choice;
import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;

import java.util.List;

public interface QuestionDTO {

    Question toQuestion();

    void setName(String name);

    void setType(QuestionType type);

    void setAttributes(List<Attribute> attributes);

    void setChoices(List<Choice> choices);

    String getName();

    QuestionType getType();

    java.util.List<Attribute> getAttributes();

    java.util.List<Choice> getChoices();

}
