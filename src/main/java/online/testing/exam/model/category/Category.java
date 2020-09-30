package online.testing.exam.model.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;

    private String label;

    private String backgroundColor;

    private String color;

    public Category(String label, String backgroundColor, String color) {
        this.id = id;
        this.label = label;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public static class Builder implements CategoryBuilder {
        private String id;
        private String label;
        private String backgroundColor;
        private String color;

        public CategoryBuilder id(String id) {
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
            Category category = new Category(this.id, this.label, this.backgroundColor, this.color);
            return category;
        }
    }
}
