package com.depa.testing.system.exam.model.question;

import com.depa.testing.system.category.model.Category;
import com.depa.testing.system.exam.dto.CategoryDTO;

import java.util.List;

public class SubjectiveQuestion extends Question {

    private SubjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static SubjectiveQuestion create(String name, List<Attribute> attributes, List<Category> categories) {
        SubjectiveQuestion question = new SubjectiveQuestion(QuestionType.SUBJECTIVE);
        question.setName(name);
        question.setAttributes(attributes);
        question.setCategories(categories);
        return question;
    }

}
