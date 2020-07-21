package com.depa.exam.dto;

import com.depa.exam.model.category.Category;
import org.bson.types.ObjectId;

public interface CategoryDTO {

    ObjectId getId();

    void setId(ObjectId id);

    String getLabel();

    void setLabel(String history);

    String getBackgroundColor();

    void setBackgroundColor(String s);

    String getColor();

    void setColor(String s);

    Category toCategory();
}
