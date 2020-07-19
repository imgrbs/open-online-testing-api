package com.depa.category.service;

import com.depa.category.dto.CategoryDTO;
import com.depa.category.model.Category;
import com.depa.category.model.CategoryBuilder;
import com.depa.category.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    void setCategoryRepository(CategoryRepository mockCategoryRepository);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    List<Category> getCategories();

    void setCategoryBuilder(CategoryBuilder mockCategoryBuilder);
}
