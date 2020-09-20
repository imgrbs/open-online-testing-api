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
import java.util.Date;
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
    private Date startAt;
    private Date endAt;
    private List<Question> questions;
    private List<CategoryDTOImpl> categories = new ArrayList<>();
    private ExamType examType = ExamType.TRADITIONAL;

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

//    public Exam(ObjectId id, String exam_name, String exam_description, ArrayList<Object> arrayList, ArrayList<Object> arrayList0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public Exam(ObjectId objectId, String exam_Set_1, String set_A, ArrayList<Object> arrayList, List<CategoryDTOImpl> categories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
