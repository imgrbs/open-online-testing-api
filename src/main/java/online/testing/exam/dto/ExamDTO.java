package online.testing.exam.dto;

import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.model.exam.ExamType;
import java.util.Date;

import java.util.List;

public interface ExamDTO {

    Exam toExam();

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<QuestionDTOImpl> getQuestions();

    void setQuestions(List<QuestionDTOImpl> questions);

    List<CategoryDTOImpl> getCategories();

    void setCategories(List<CategoryDTOImpl> categories);

    ExamType getType();

    void setType(ExamType examType);

    public String getId();

    public void setId(String id);

    public void setStartAt(Date startAt);

    public Date getStartAt();

    public void setEndAt(Date startAt);

    public Date getEndAt();

}
