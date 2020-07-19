package com.depa.exam.model.question;

import com.depa.category.dto.CategoryDTO;

import java.util.List;

public class SubjectiveQuestion extends Question {

    private SubjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static SubjectiveQuestion create(String name, List<Attribute> attributes, List<CategoryDTO> categories) {
        SubjectiveQuestion question = new SubjectiveQuestion(QuestionType.SUBJECTIVE);
        question.setName(name);
        question.setAttributes(attributes);
        question.setCategories(categories);
        return question;
    }

}
