package online.testing.exam.service;

import online.testing.exam.dto.CategoryDTO;
import online.testing.exam.model.category.Category;
import online.testing.exam.model.category.CategoryBuilder;
import online.testing.exam.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    
    void setCategoryRepository(CategoryRepository mockCategoryRepository);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    List<Category> getCategories();

    void setCategoryBuilder(CategoryBuilder mockCategoryBuilder);
}
