package com.depa.observer;

import com.depa.category.service.CategoryService;
import com.depa.exam.dto.impl.QuestionDTOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CategoryListener implements ApplicationListener<CustomSpringEvent> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void onApplicationEvent(CustomSpringEvent customSpringEvent) {
        if (customSpringEvent.getName().equals("question_created")) {
            System.out.println("Received spring custom event " + customSpringEvent.getName());
            onQuestionCreated((QuestionDTOImpl) customSpringEvent.getSource());
        }
    }

    void onQuestionCreated(QuestionDTOImpl questionDTO) {
        questionDTO.getCategories().forEach(categoryDTO -> {
            categoryService.createCategory(categoryDTO);
        });
    }
}
