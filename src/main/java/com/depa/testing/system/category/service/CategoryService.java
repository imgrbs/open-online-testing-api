package com.depa.testing.system.category.service;

import com.depa.testing.system.category.model.Category;
import com.depa.testing.system.category.model.CategoryBuilder;
import com.depa.testing.system.category.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    void setCategoryRepository(CategoryRepository mockCategoryRepository);

    Category createCategory(Category category);

    List<Category> getCategories();

    void setCategoryBuilder(CategoryBuilder mockCategoryBuilder);
}
