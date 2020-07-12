package com.depa.form.dto;

import com.depa.form.model.question.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class QuestionDTO {

    private String name;
    private QuestionType questionType;
    private List<Attribute> attributes;
    private List<ChoiceList> choices;

    public QuestionDTO() {
    }

    public QuestionDTO(Question question) {
        this.name = question.getName();
        this.questionType = question.getType();
        this.attributes = question.getAttributes();

        if (this.questionType.equals(QuestionType.OBJECTIVE)) {
            this.choices = ((ObjectiveQuestion) question).getChoices();
        }
    }

    public Question toQuestion() {
        if (questionType.equals(QuestionType.OBJECTIVE)) {
            return ObjectiveQuestion.create(attributes, choices);
        }
        return SubjectiveQuestion.create(name, attributes);
    }

}
