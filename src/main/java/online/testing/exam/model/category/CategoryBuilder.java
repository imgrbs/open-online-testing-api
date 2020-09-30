package online.testing.exam.model.category;


public interface CategoryBuilder {
    CategoryBuilder id(String id);

    CategoryBuilder label(String label);

    CategoryBuilder color(String color);

    CategoryBuilder backgroundColor(String backgroundColor);

    Category build();
}
