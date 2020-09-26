package com.depa.exam.service.internal;

import com.depa.exam.dto.CategoryDTO;
import com.depa.exam.dto.impl.CategoryDTOImpl;
import com.depa.exam.model.category.Category;
import com.depa.exam.model.category.CategoryBuilder;
import com.depa.exam.repository.CategoryRepository;
import com.depa.exam.service.CategoryService;
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
        System.out.println("======= Create CAtagory ========");
        System.out.println("Label From Request: " + categoryDTO.getLabel());
        Optional<Category> categoryFromDB = categoryRepository.findByLabel(categoryDTO.getLabel());
        System.out.println("after find");
        System.out.println(categoryFromDB);
        Category categoryForSave;
        if (categoryFromDB.isPresent()) {
            System.out.println("is Present !!!");
            categoryForSave = buildCategory(categoryDTO, categoryFromDB);
        } else {
            System.out.println("Not present !!!");
            categoryForSave = categoryDTO.toCategory();
        }
        System.out.println("Going to save !!!");
        Category result = categoryRepository.save(categoryForSave);
        return new CategoryDTOImpl(result);
    }

    private Category buildCategory(CategoryDTO category, Optional<Category> categoryFromDB) {
        Category categoryForSave = categoryBuilder
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
