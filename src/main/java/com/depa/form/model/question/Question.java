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
    private long id;

    private String name;
    
    private QuestionType type;
    
    private List<Attribute> attributes;

    private Question() {
    }

    public Question(QuestionType type) {
        this.type = type;
    }
}
