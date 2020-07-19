package com.depa.exam.model.question;

import com.depa.category.model.Category;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("questions")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Question {
    
    @Id
    private ObjectId id;

    private String name;
    
    private QuestionType type;
    
    private List<Attribute> attributes;

    private List<Category> categories;

    public Question(QuestionType type) {
        this.type = type;
    }
}
