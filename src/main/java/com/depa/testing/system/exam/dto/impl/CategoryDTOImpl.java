package com.depa.testing.system.exam.dto.impl;

import com.depa.testing.system.category.model.Category;
import com.depa.testing.system.exam.dto.CategoryDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTOImpl implements CategoryDTO {
    private ObjectId id;
    private String label;
    private String backgroundColor;
    private String color;

    public CategoryDTOImpl(String label, String backgroundColor, String color) {
        this.label = label;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public CategoryDTOImpl(Category category) {
        this.id = category.getId();
        this.label = category.getLabel();
        this.backgroundColor = category.getBackgroundColor();
        this.color = category.getColor();
    }

    @Override
    public Category toCategory() {
        return new Category(this);
    }
}
