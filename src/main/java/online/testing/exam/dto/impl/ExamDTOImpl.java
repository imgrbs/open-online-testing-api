package online.testing.exam.dto.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.testing.exam.dto.ExamDTO;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.model.exam.ExamType;

@NoArgsConstructor
@Getter
@Setter
public class ExamDTOImpl implements ExamDTO {

    private String id;
    private String name;
    private String description;
    private List<QuestionDTOImpl> questions;
    private List<CategoryDTOImpl> categories;
    private Date startAt;
    private Date endAt;
    private ExamType type = ExamType.TRADITIONAL;

    public ExamDTOImpl(Exam exam) {
        this.id = exam.getId();
        this.name = exam.getName();
        this.description = exam.getDescription();
        this.questions = new ArrayList<>();
        this.categories = exam.getCategories();
        this.endAt = exam.getEndAt();
        this.startAt = exam.getStartAt();

        if (exam.getQuestions() != null) {
            exam.getQuestions().forEach(field -> {
                this.questions.add(new QuestionDTOImpl(field));
            });
        }
    }

    @Override
    public Exam toExam() {
        return new Exam(this);
    }

    @Override
    public String toString() {
        return "ExamDTOImpl{" + "id=" + id + ", name=" + name + ", description=" + description + ", questions=" + questions + ", categories=" + categories + ", startAt=" + startAt + ", endAt=" + endAt + ", type=" + type + '}';
    }
    
    

}
