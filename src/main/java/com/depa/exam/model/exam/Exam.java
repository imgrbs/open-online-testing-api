package com.depa.exam.model.exam;

import com.depa.exam.dto.CategoryDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.CategoryDTOImpl;
import com.depa.exam.model.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document("exams")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Exam {
    @Id
    private ObjectId id;
    private String name;
    private String description;

    private List<Question> questions;

    private List<CategoryDTOImpl> categories = new ArrayList<>();

    public Exam(ExamDTO examDTO) {
        this.name = examDTO.getName();
        this.description = examDTO.getDescription();
        this.questions = new ArrayList<>();

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
