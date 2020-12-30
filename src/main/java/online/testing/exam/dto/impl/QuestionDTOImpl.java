package online.testing.exam.dto.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.testing.exam.dto.QuestionDTO;
import online.testing.exam.model.question.Attribute;
import online.testing.exam.model.question.Choice;
import online.testing.exam.model.question.ObjectiveQuestion;
import online.testing.exam.model.question.Question;
import online.testing.exam.model.question.QuestionType;
import online.testing.exam.model.question.SubjectiveQuestion;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuestionDTOImpl implements QuestionDTO {

    private String id;
    private String name;
    private QuestionType type;
    private List<Attribute> attributes;
    private List<ChoiceDTO> choices;
    private List<CategoryDTOImpl> categories;
    private boolean isMultipleChoose;
    private String ownerId;

    public QuestionDTOImpl(Question question) {
        this.id = question.getId();
        this.name = question.getName();
        this.type = question.getType();
        this.attributes = question.getAttributes();
        this.categories = question.getCategories();

        if (this.type.equals(QuestionType.OBJECTIVE)) {
            ObjectiveQuestion objectiveQuestion = (ObjectiveQuestion) question;

            this.choices = new ArrayList<>();
            for (Choice choice : objectiveQuestion.getChoices()) {
                this.choices.add(ChoiceDTO.fromEntity(choice));

            }
            this.isMultipleChoose = objectiveQuestion.isIsMultipleChoose();
        }
        System.out.println(isMultipleChoose);
    }

    /**
     * it didnt use boolean multiplechoice that we have been implement
     *
     * @return
     */
    @Override
    public Question toQuestion() {
        Question question;
        if (type.equals(QuestionType.SUBJECTIVE)) {
            question = SubjectiveQuestion.create(id, name, attributes, categories);
        } else {
            List<Choice> choices = new ArrayList<>();
            for (ChoiceDTO choiceDTO : this.choices) {
                choices.add(Choice.fromDTO(choiceDTO));
            }
            question = ObjectiveQuestion.create(id, name, attributes, choices, categories);
        }
        question.setOwnerId(ownerId);
        return question;
    }

    @Override
    public boolean getIsMultipleChoose() {
        return isMultipleChoose;
    }

}
