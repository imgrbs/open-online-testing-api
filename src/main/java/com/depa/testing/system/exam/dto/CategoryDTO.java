package com.depa.testing.system.exam.dto;

import com.depa.testing.system.category.model.Category;
import org.bson.types.ObjectId;

public interface CategoryDTO {

    public void setId(ObjectId id);

    public void setLabel(String label);

    public void setBackgroundColor(String backgroundColor);

    public void setColor(String color);

    public ObjectId getId();

    public String getLabel();

    public String getBackgroundColor();

    public String getColor();

    public Category toCategory();
}
