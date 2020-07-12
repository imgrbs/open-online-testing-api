package com.depa.form.model.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public abstract class Question {
    
    @Id
    private long fieldId;
    
    private QuestionType questionType;
    
    private List<Attribute> attributes;

    private Question() {
    }

    public Question(QuestionType type) {
        this.questionType = type;
    }
    
}
