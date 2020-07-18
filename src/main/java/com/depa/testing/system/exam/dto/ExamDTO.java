package com.depa.testing.system.exam.dto;

import com.depa.testing.system.exam.dto.impl.QuestionDTOImpl;
import com.depa.testing.system.exam.model.exam.Exam;

import java.util.List;

public interface ExamDTO {

    Exam toExam();

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<QuestionDTOImpl> getQuestions();

    void setQuestions(List<QuestionDTOImpl> questions);
}
