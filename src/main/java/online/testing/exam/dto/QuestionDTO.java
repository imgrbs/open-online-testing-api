package online.testing.exam.dto;

import java.util.List;

import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.model.question.Attribute;
import online.testing.exam.model.question.Choice;
import online.testing.exam.model.question.Question;
import online.testing.exam.model.question.QuestionType;

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
    
    public String getId();
    
    public void setId(String id);

    void setOwnerId(String ownerId);
    
    void setMultipleChoose(boolean isMultipleChoose);
    
    boolean getIsMultipleChoose();
}
