package com.depa.testing.system.exam.dto;

import com.depa.testing.system.exam.model.question.Attribute;
import com.depa.testing.system.exam.model.question.Choice;
import com.depa.testing.system.exam.model.question.Question;
import com.depa.testing.system.exam.model.question.QuestionType;

import java.util.List;

public interface QuestionDTO {

    Question toQuestion();

    void setName(String name);

    void setType(QuestionType type);

    void setAttributes(List<Attribute> attributes);

    void setChoices(List<Choice> choices);

    String getName();

    QuestionType getType();

    List<Attribute> getAttributes();

    List<Choice> getChoices();

}
