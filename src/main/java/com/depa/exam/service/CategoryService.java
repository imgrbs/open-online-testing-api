package com.depa.exam.service;

import com.depa.exam.dto.CategoryDTO;
import com.depa.exam.model.category.Category;
import com.depa.exam.model.category.CategoryBuilder;
import com.depa.exam.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    
    void setCategoryRepository(CategoryRepository mockCategoryRepository);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    List<Category> getCategories();

    void setCategoryBuilder(CategoryBuilder mockCategoryBuilder);
}
