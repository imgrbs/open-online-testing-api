package com.depa.exam.dto;

import com.depa.exam.dto.impl.CategoryDTOImpl;
import com.depa.exam.dto.impl.QuestionDTOImpl;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.model.exam.ExamType;

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
    
    ExamType getExamType();
    
}
