package com.depa.exam.dto;

import com.depa.exam.model.category.Category;
import org.bson.types.ObjectId;

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
