/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.dto.impl;

import com.depa.exam.dto.ExamDTO;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.model.exam.ExamType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

/**
 *
 * @author Test
 */
@NoArgsConstructor
@Getter
@Setter
public class ExamExcludeQuestionDTOImpl implements ExamDTO{
    private ObjectId id;
    private String name;
    private String description;
    private List<QuestionDTOImpl> questions;
    private List<CategoryDTOImpl> categories;
    private Date startAt;
    private Date endAt;
    private ExamType examType;

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
