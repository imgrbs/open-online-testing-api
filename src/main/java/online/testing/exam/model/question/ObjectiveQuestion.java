package online.testing.exam.model.question;

import java.util.List;

import online.testing.exam.dto.impl.CategoryDTOImpl;

public class ObjectiveQuestion extends Question {

    private boolean isMultipleChoose;

    private List<Choice> choices;

    public ObjectiveQuestion(QuestionType type) {
        super(type);
    }

    public static ObjectiveQuestion create(String id, String name, List<Attribute> attributes, List<Choice> choices, List<CategoryDTOImpl> categories) {
        ObjectiveQuestion field = new ObjectiveQuestion(QuestionType.OBJECTIVE);
        field.setId(id);
        field.setName(name);
        field.setAttributes(attributes);
        field.setChoices(choices);
        field.setCategories(categories);

        int choiceSize = field.getChoices().size();
        int numberOfCorrectChoice = 0;
        field.setIsMultipleChoose(false);
        for (int i = 0; i < choiceSize; i++) {
            boolean isCorrectAnswer = field.getChoices().get(i).getIsCorrectAnswer();
            if (isCorrectAnswer == true) {
                numberOfCorrectChoice++;
            }
        }
        if (numberOfCorrectChoice > 1) {
            field.setIsMultipleChoose(true);
        }
        return field;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public boolean isIsMultipleChoose() {
        return isMultipleChoose;
    }

    public void setIsMultipleChoose(boolean isMultipleChoose) {
        this.isMultipleChoose = isMultipleChoose;
    }

    @Override
    public String toString() {
        return "ObjectiveQuestion{" + "isMultipleChoose=" + isMultipleChoose + ", choices=" + choices + '}';
    }

}
