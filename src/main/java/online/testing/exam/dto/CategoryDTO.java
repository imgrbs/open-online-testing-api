package online.testing.exam.dto;

import online.testing.exam.model.category.Category;

public interface CategoryDTO {

    String getId();

    void setId(String id);

    String getLabel();

    void setLabel(String history);

    String getBackgroundColor();

    void setBackgroundColor(String s);

    String getColor();

    void setColor(String s);

    Category toCategory();
}
