package com.depa.testing.system.exam.model.question;

import com.depa.testing.system.category.model.Category;
import com.depa.testing.system.exam.dto.CategoryDTO;

import java.util.List;

public class ObjectiveQuestion extends Question {

    private List<Choice> choices;

    public ObjectiveQuestion(QuestionType type) {
        super(type);
    }

    private static ObjectiveQuestion create(List<Attribute> attributes, List<Choice> choices, List<Category> categories) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setAttributes(attributes);
        field.setChoices(choices);
        field.setCategories(categories);
        return field;
    }

    public static ObjectiveQuestion create(String name, List<Choice> choices, List<Attribute> attributes, List<Category> categories) {
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
