package online.testing.exam.dto.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.testing.exam.model.question.Choice;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"isCorrectAnswer"}, allowSetters = true)
public class ChoiceDTO {
    private String label;
    @JsonProperty("isCorrectAnswer")
    private Boolean isCorrectAnswer;

    public static ChoiceDTO fromEntity(Choice choice) {
        return new ChoiceDTO(choice.getLabel(), choice.isCorrectAnswer());
    }
}
