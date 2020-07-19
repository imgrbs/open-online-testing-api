package com.depa.exam.dto.impl;

import com.depa.category.dto.CategoryDTO;
import com.depa.category.model.Category;
import com.depa.exam.dto.QuestionDTO;
import com.depa.exam.model.question.*;
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
    private List<CategoryDTO> categories;

    public QuestionDTOImpl(Question question) {
        this.id = question.getId();
        this.name = question.getName();
        this.type = question.getType();
        this.attributes = question.getAttributes();
        this.categories = question.getCategories();

        if (this.type.equals(QuestionType.OBJECTIVE)) {
            this.choices = ((ObjectiveQuestion) question).getChoices();
        }
    }

    @Override
    public Question toQuestion() {
        if (type.equals(QuestionType.SUBJECTIVE)) {
            return SubjectiveQuestion.create(name, attributes, categories);
        }
        return ObjectiveQuestion.create(name, choices, attributes, categories);
    }
}
