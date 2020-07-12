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
    private List<ChoiceList> choiceList;

    public QuestionDTO() {
    }

    public QuestionDTO(Question question) {
        this.questionType = question.getType();
        this.attributes = question.getAttributes();

        if (this.questionType.equals(QuestionType.CHECKBOX)) {
            this.choiceList = ((Checkbox) question).getChoiceList();
        }
    }

    public Question toQuestion() {
        if (questionType.equals(QuestionType.TEXTAREA)) {
            return TextArea.create(attributes);
        }
        else if (questionType.equals(QuestionType.TEXTAREA)) {
            return TextArea.create(attributes);
        }
        else if (questionType.equals(QuestionType.CHECKBOX)) {
            return Checkbox.create(attributes, choiceList);
        }
        return Input.create(name, attributes);
    }

}
