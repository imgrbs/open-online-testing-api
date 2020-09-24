package com.depa.exam.model.question;

import com.depa.exam.dto.impl.CategoryDTOImpl;

import java.util.List;

public class SubjectiveQuestion extends Question {

    public static Question create(String id, String name, List<Attribute> attributes, List<CategoryDTOImpl> categories) {
        SubjectiveQuestion question = new SubjectiveQuestion(QuestionType.SUBJECTIVE);
        question.setId(id);
        question.setName(name);
        question.setAttributes(attributes);
        question.setCategories(categories);
        return question;
    }

    private SubjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static SubjectiveQuestion create(String name, List<Attribute> attributes, List<CategoryDTOImpl> categories) {
        SubjectiveQuestion question = new SubjectiveQuestion(QuestionType.SUBJECTIVE);
        question.setName(name);
        question.setAttributes(attributes);
        question.setCategories(categories);
        return question;
    }

}
