package com.depa.category.service.internal;

import com.depa.category.model.Category;
import com.depa.category.model.CategoryBuilder;
import com.depa.category.repository.CategoryRepository;
import com.depa.category.service.CategoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryBuilder categoryBuilder = new Category.Builder();

    @Override
    public Category createCategory(Category category) {
        Optional<Category> categoryFromDB = categoryRepository.findByLabel(category.getLabel());
        Category categoryForSave = category;
        if (categoryFromDB.isPresent()) {
            categoryForSave = buildCategory(category, categoryFromDB);
        }
        Category result = categoryRepository.save(categoryForSave);
        return result;
    }

    private Category buildCategory(Category category, Optional<Category> categoryFromDB) {
        Category categoryForSave;
        categoryForSave = categoryBuilder
                .id(categoryFromDB.get().getId())
                .label(category.getLabel())
                .backgroundColor(category.getBackgroundColor())
                .color(category.getColor())
                .build();
        return categoryForSave;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
