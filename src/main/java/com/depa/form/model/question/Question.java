package com.depa.form.model.question;

import lombok.Data;

@Data
public abstract class Question {
    protected QuestionType type;
    protected String questionText;
}
