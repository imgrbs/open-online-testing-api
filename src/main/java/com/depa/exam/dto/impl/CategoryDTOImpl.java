package com.depa.exam.dto.impl;

import com.depa.exam.dto.CategoryDTO;
import com.depa.exam.model.category.Category;
import com.depa.exam.model.category.CategoryBuilder;
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
//
//    @Override
//    public String toString() {
//        return "CategoryDTOImpl{" + "id=" + id + ", label=" + label + ", backgroundColor=" + backgroundColor + ", color=" + color + '}';
//    }
}
