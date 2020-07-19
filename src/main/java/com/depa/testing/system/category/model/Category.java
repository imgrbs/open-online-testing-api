package com.depa.testing.system.category.model;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.depa.testing.system.exam.dto.CategoryDTO;
import com.depa.testing.system.exam.dto.impl.CategoryDTOImpl;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private ObjectId id;

    private String label;

    private String backgroundColor;

    private String color;

    public Category(String label, String backgroundColor, String color) {
        this.label = label;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public Category(CategoryDTO categoryDTO) {
        this.id = categoryDTO.getId();
        this.label = categoryDTO.getLabel();
        this.backgroundColor = categoryDTO.getBackgroundColor();
        this.color = categoryDTO.getColor();
    }

    public Category(Category category) {
        this.id = category.id;
        this.label = category.label;
        this.backgroundColor = category.backgroundColor;
        this.color = category.color;
    }

    public void updateFields(Category category) {
        this.setColor(category.getColor());
        this.setBackgroundColor(category.getBackgroundColor());
    }

    public static class Builder implements CategoryBuilder {
        private ObjectId id;
        private String label;
        private String backgroundColor;
        private String color;

        public Builder() {

        }

        public CategoryBuilder id(ObjectId id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder label(String label) {
            this.label = label;
            return this;
        }

        public CategoryBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CategoryBuilder backgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Category build() {
            Category category = new Category(this.label, this.backgroundColor, this.color);
            category.setId(this.id);
            return category;
        }
    }
}
