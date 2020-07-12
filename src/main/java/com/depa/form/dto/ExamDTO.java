package com.depa.form.dto;

import com.depa.form.model.exam.Exam;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ExamDTO {
    private String name;
    private String description;
    private List<QuestionDTO> fields;
  
    public ExamDTO(Exam exam) {
        this.name = exam.getName();
        this.description = exam.getDescription();
        this.fields = new ArrayList<>();

        if (exam.getQuestions() != null) {
            exam.getQuestions().forEach(field -> {
                this.fields.add(new QuestionDTO(field));
            });
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionDTO> getFields() {
        return fields;
    }

    public void setFields(List<QuestionDTO> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "FormDTO{" + "name=" + name + ", description=" + description + ", fields=" + fields + '}';
    }
    
}
