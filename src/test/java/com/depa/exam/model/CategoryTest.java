package com.depa.exam.model;

import com.depa.exam.model.category.Category;
import org.bson.types.ObjectId;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void testCategoryFields() {
        Category underTest = new Category();

        Assert.assertThat(underTest.getLabel(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getBackgroundColor(), CoreMatchers.nullValue());
        Assert.assertThat(underTest.getColor(), CoreMatchers.nullValue());
    }

    @Test
    void testCategoryBuilder() {
        Category expectedCategory = new Category();
        expectedCategory.setId(ObjectId.get());
        expectedCategory.setLabel("history");
        expectedCategory.setBackgroundColor("#000000");
        expectedCategory.setColor("#ffffff");
        Category.Builder underTest = new Category.Builder();

        Category actual = underTest
                .id(expectedCategory.getId())
                .label(expectedCategory.getLabel())
                .color(expectedCategory.getColor())
                .backgroundColor(expectedCategory.getBackgroundColor())
                .build();

        Assert.assertThat(actual.getId(), CoreMatchers.equalTo(expectedCategory.getId()));
        Assert.assertThat(actual.getLabel(), CoreMatchers.equalTo(expectedCategory.getLabel()));
        Assert.assertThat(actual.getBackgroundColor(), CoreMatchers.equalTo(expectedCategory.getBackgroundColor()));
        Assert.assertThat(actual.getColor(), CoreMatchers.equalTo(expectedCategory.getColor()));
    }
}