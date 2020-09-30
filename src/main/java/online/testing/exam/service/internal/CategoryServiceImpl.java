package online.testing.exam.service.internal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import online.testing.exam.dto.CategoryDTO;
import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.model.category.Category;
import online.testing.exam.model.category.CategoryBuilder;
import online.testing.exam.repository.CategoryRepository;
import online.testing.exam.service.CategoryService;

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
