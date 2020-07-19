package com.depa.category.dto;

import com.depa.category.model.Category;
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
