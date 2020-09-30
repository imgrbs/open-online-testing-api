package online.testing.exam.model.question;

import java.util.List;

import online.testing.exam.dto.impl.CategoryDTOImpl;

public class ObjectiveQuestion extends Question {

    public static Question create(String id, String name, List<Choice> choices, List<Attribute> attributes, List<CategoryDTOImpl> categories) {
        ObjectiveQuestion question = create(id, attributes, choices, categories);
        question.setName(name);
        return question;
    }

    private List<Choice> choices;

    public ObjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static ObjectiveQuestion create(String id, List<Attribute> attributes, List<Choice> choices, List<CategoryDTOImpl> categories) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setId(id);
        field.setName(id);
        field.setAttributes(attributes);
        field.setChoices(choices);
        field.setCategories(categories);
        return field;
    }

//    public static ObjectiveQuestion create(String name, List<Choice> choices, List<Attribute> attributes, List<CategoryDTOImpl> categories) {
//        ObjectiveQuestion question = create(attributes, choices, categories);
//        question.setName(name);
//        return question;
//    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

}
