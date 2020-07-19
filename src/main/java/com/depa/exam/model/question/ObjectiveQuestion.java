package com.depa.exam.model.question;

import com.depa.category.dto.CategoryDTO;

import java.util.List;

public class ObjectiveQuestion extends Question {

    private List<Choice> choices;

    public ObjectiveQuestion(QuestionType type) {
        super(type);
    }

    private static ObjectiveQuestion create(List<Attribute> attributes, List<Choice> choices, List<CategoryDTO> categories) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setAttributes(attributes);
        field.setChoices(choices);
        field.setCategories(categories);
        return field;
    }

    public static ObjectiveQuestion create(String name, List<Choice> choices, List<Attribute> attributes, List<CategoryDTO> categories) {
        ObjectiveQuestion question = create(attributes, choices, categories);
        question.setName(name);
        return question;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    
}
