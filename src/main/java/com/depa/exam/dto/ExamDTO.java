package com.depa.exam.dto;

import com.depa.exam.dto.impl.CategoryDTOImpl;
import com.depa.exam.dto.impl.QuestionDTOImpl;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.model.exam.ExamType;
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
