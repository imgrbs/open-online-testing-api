package com.depa.exam.model.question;

import java.util.List;

public class SubjectiveQuestion extends Question {

    private SubjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static SubjectiveQuestion create(String name, List<Attribute> attributes) {
        SubjectiveQuestion question = new SubjectiveQuestion(QuestionType.SUBJECTIVE);
        question.setName(name);
        question.setAttributes(attributes);
        return question;
    }

}
