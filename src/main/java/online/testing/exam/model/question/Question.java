package online.testing.exam.model.question;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.testing.exam.dto.impl.CategoryDTOImpl;


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

    private String ownerId;

    public Question(QuestionType type) {
        this.type = type;
    }
}
