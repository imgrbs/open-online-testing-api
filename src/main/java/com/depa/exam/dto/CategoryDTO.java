package com.depa.exam.dto;

import com.depa.exam.model.category.Category;
import org.bson.types.ObjectId;

public interface CategoryDTO {

    ObjectId getId();

    String getLabel();

    String getBackgroundColor();

    String getColor();

    void setId(ObjectId id);

    void setLabel(String history);

    void setBackgroundColor(String s);

    void setColor(String s);

    Category toCategory();
}
