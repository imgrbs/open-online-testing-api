package com.depa.exam.model.exam;

import com.depa.exam.dto.ExamDTO;
import com.depa.exam.model.question.Question;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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

    public Exam(ExamDTO examDTO) {
        this.name = examDTO.getName();
        this.description = examDTO.getDescription();
        this.questions = new ArrayList<>();

        if (examDTO.getQuestions() != null) {
            examDTO.getQuestions().forEach(fieldDTO -> {
                this.questions.add(fieldDTO.toQuestion());
            });
        }
    }

}
