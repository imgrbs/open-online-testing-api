package online.testing.exam.model.question;

import online.testing.exam.dto.impl.CategoryDTOImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("questions")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Question {

    @Id
    private String id;

    private String name;

    private QuestionType type = QuestionType.OBJECTIVE;

    private List<Attribute> attributes;

    private List<CategoryDTOImpl> categories;
    
    public Question(QuestionType type) {
        this.type = type;
    }
}
