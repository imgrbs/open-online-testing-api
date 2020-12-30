/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.testing.exam.model.question;

import lombok.*;
import online.testing.exam.dto.impl.ChoiceDTO;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private String label;
    private boolean isCorrectAnswer;

    public static Choice fromDTO(ChoiceDTO choiceDTO) {
        Choice choice = new Choice();
        choice.setLabel(choiceDTO.getLabel());
        if (choiceDTO.getIsCorrectAnswer() != null) {
            choice.setCorrectAnswer(choiceDTO.getIsCorrectAnswer());
        }
        return choice;
    }
}
