package com.depa.testing.system.exam.dto.impl;

import com.depa.testing.system.exam.dto.QuestionDTO;
import com.depa.testing.system.exam.model.question.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuestionDTOImpl implements QuestionDTO {

    private ObjectId id;
    private String name;
    private QuestionType type;
    private List<Attribute> attributes;
    private List<Choice> choices;

    public QuestionDTOImpl(Question question) {
        this.id = question.getId();
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
