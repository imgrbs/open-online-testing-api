package online.testing.exam.model.exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.model.question.Question;

@Document("exams")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Exam {

    @Id
    private String id;
    private String name;
    private String description;
    private Date startAt;
    private Date endAt;
    private List<Question> questions;
    private List<CategoryDTOImpl> categories = new ArrayList<>();
    private ExamType type;

    private String ownerId;

    public Exam(ExamDTO examDTO) {
        this.name = examDTO.getName();
        this.description = examDTO.getDescription();
        this.questions = new ArrayList<>();
        this.endAt = examDTO.getEndAt();
        this.startAt = examDTO.getStartAt();
        if (examDTO.getQuestions() != null) {
            examDTO.getQuestions().forEach(fieldDTO -> {
                this.questions.add(fieldDTO.toQuestion());
            });
        }

        if (examDTO.getCategories() != null) {
            this.categories = examDTO.getCategories();
        }
    }

}
