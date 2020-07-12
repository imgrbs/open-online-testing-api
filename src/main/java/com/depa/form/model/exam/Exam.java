package com.depa.form.model.exam;

import com.depa.form.dto.ExamDTO;
import com.depa.form.model.question.Question;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("forms")
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

        if (examDTO.getFields() != null) {
            System.out.println("Field != null");
            examDTO.getFields().forEach(fieldDTO -> {
                System.out.println(fieldDTO);
                this.questions.add(fieldDTO.toQuestion());
            });
        }
    }
    
    @Override
    public String toString() {
        return "Form{" + "id=" + id + ", name=" + name + ", description=" + description + ", fields=" + questions + '}';
    }

}
