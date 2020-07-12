package com.depa.form.dto.impl;

import com.depa.form.dto.QuestionDTO;
import com.depa.form.model.question.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class QuestionDTOImpl implements QuestionDTO {

    private String name;
    private QuestionType type;
    private List<Attribute> attributes;
    private List<Choice> choices;

    public QuestionDTOImpl() {
    }

    public QuestionDTOImpl(Question question) {
        this.name = question.getName();
        this.type = question.getType();
        this.attributes = question.getAttributes();

        if (this.type.equals(QuestionType.OBJECTIVE)) {
            this.choices = ((ObjectiveQuestion) question).getChoices();
        }
    }

    @Override
    public Question toQuestion() {
        if (type.equals(QuestionType.SUBJECTIVE)) {
            return SubjectiveQuestion.create(name, attributes);
        }
        return ObjectiveQuestion.create(name, choices, attributes);
    }
}
