package online.testing.exam.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import online.testing.exam.model.question.Choice;

@Data
@AllArgsConstructor
public class ChoiceDTO {
    private String label;

    public static ChoiceDTO fromEntity(Choice choice) {
        return new ChoiceDTO(choice.getLabel());
    }
}
