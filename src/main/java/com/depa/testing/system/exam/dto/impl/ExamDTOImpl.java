package com.depa.testing.system.exam.dto.impl;

import com.depa.testing.system.exam.dto.ExamDTO;
import com.depa.testing.system.exam.model.exam.Exam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ExamDTOImpl implements ExamDTO {
    private String name;
    private String description;
    private List<QuestionDTOImpl> questions;

    public ExamDTOImpl(Exam exam) {
        this.name = exam.getName();
        this.description = exam.getDescription();
        this.questions = new ArrayList<>();

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
}
