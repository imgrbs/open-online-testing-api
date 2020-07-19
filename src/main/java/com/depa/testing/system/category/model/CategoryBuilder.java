package com.depa.testing.system.category.model;

import org.bson.types.ObjectId;

public interface CategoryBuilder {
    CategoryBuilder id(ObjectId id);

    CategoryBuilder label(String label);

    CategoryBuilder color(String color);

    CategoryBuilder backgroundColor(String backgroundColor);

    Category build();
}
