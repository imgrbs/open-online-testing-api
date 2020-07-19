package com.depa.category.dto.impl;

import com.depa.category.dto.CategoryDTO;
import com.depa.category.model.Category;
import com.depa.category.model.CategoryBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTOImpl implements CategoryDTO {
    private ObjectId id;
    private String label;
    private String backgroundColor;
    private String color;

    public CategoryDTOImpl(Category category) {
        this.id = category.getId();
        this.label = category.getLabel();
        this.backgroundColor = category.getBackgroundColor();
        this.color = category.getColor();
    }

    @Override
    public Category toCategory() {
        CategoryBuilder builder = new Category.Builder();
        return builder
            .id(this.id)
            .label(this.label)
            .backgroundColor(this.backgroundColor)
            .color(this.color)
            .build();
    }
}
