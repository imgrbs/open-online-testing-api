package com.depa.category.service.internal;

import com.depa.category.dto.CategoryDTO;
import com.depa.category.dto.impl.CategoryDTOImpl;
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
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Optional<Category> categoryFromDB = categoryRepository.findByLabel(categoryDTO.getLabel());
        Category categoryForSave;
        if (categoryFromDB.isPresent()) {
            categoryForSave = buildCategory(categoryDTO, categoryFromDB);
        } else {
            categoryForSave = categoryDTO.toCategory();
        }
        Category result = categoryRepository.save(categoryForSave);
        return new CategoryDTOImpl(result);
    }

    private Category buildCategory(CategoryDTO category, Optional<Category> categoryFromDB) {
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
