package com.depa.exam.dto;

import com.depa.exam.dto.impl.CategoryDTOImpl;
import com.depa.exam.model.question.Attribute;
import com.depa.exam.model.question.Choice;
import com.depa.exam.model.question.Question;
import com.depa.exam.model.question.QuestionType;

import java.util.List;
import org.bson.types.ObjectId;

public interface QuestionDTO {

    Question toQuestion();

    String getName();

    void setName(String name);

    QuestionType getType();

    void setType(QuestionType type);

    List<Attribute> getAttributes();

    void setAttributes(List<Attribute> attributes);

    List<Choice> getChoices();

    void setChoices(List<Choice> choices);

    List<CategoryDTOImpl> getCategories();

    void setCategories(List<CategoryDTOImpl> categories);
    
}
