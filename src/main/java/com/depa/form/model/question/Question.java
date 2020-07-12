package com.depa.form.model.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("questions")
@Getter
@Setter
@AllArgsConstructor
public abstract class Question {
    
    @Id
    private ObjectId id;

    private String name;
    
    private QuestionType type;
    
    private List<Attribute> attributes;

    private Question() {
    }

    public Question(QuestionType type) {
        this.type = type;
    }
}
