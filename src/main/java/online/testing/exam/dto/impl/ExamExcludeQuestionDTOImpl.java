/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.testing.exam.dto.impl;

import online.testing.exam.dto.ExamDTO;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.model.exam.ExamType;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Test
 */
@NoArgsConstructor
@Getter
@Setter
public class ExamExcludeQuestionDTOImpl implements ExamDTO{
    private String id;
    private String name;
    private String description;
    private List<QuestionDTOImpl> questions;
    private List<CategoryDTOImpl> categories;
    private Date startAt;
    private Date endAt;
    private ExamType type;

    public ExamExcludeQuestionDTOImpl(Exam exam) {
        this.id = exam.getId();
        this.name = exam.getName();
        this.description = exam.getDescription();
        this.categories = exam.getCategories();
        this.startAt = exam.getStartAt();
        this.endAt = exam.getEndAt();
    }

    @Override
    public Exam toExam() {
        return new Exam(this);
    }

    
}
