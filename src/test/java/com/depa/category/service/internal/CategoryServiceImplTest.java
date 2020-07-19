package com.depa.category.service.internal;

import com.depa.category.dto.CategoryDTO;
import com.depa.category.dto.impl.CategoryDTOImpl;
import com.depa.category.model.Category;
import com.depa.category.model.CategoryBuilder;
import com.depa.category.repository.CategoryRepository;
import com.depa.category.service.CategoryService;
import org.bson.types.ObjectId;
import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImplTest {
    JUnit4Mockery mockery = new JUnit4Mockery();

    private CategoryService underTest;
    private CategoryRepository mockCategoryRepository;
    private CategoryBuilder mockCategoryBuilder;

    @BeforeEach
    public void setUp() throws Exception {
        underTest = new CategoryServiceImpl();
        mockCategoryRepository = mockery.mock(CategoryRepository.class);
        underTest.setCategoryRepository(mockCategoryRepository);
        mockCategoryBuilder = mockery.mock(CategoryBuilder.class);
        underTest.setCategoryBuilder(mockCategoryBuilder);
    }

    @Test
    public void testCreateCategory_whenDoesNotExists() {
        Category category = createCategory();
        CategoryDTO mockQuestionDTO = createCategoryDTO(category);

        CategoryDTO actual = underTest.createCategory(mockQuestionDTO);

        Assert.assertThat(actual.getLabel(), CoreMatchers.equalTo(category.getLabel()));
        Assert.assertThat(actual.getBackgroundColor(), CoreMatchers.equalTo(category.getBackgroundColor()));
        Assert.assertThat(actual.getBackgroundColor(), CoreMatchers.equalTo(category.getBackgroundColor()));
    }

    private CategoryDTO createCategoryDTO(Category category) {
        CategoryDTO mockQuestionDTO = mockery.mock(CategoryDTO.class);
        mockery.checking(new Expectations() {
            {
                oneOf(mockQuestionDTO).getLabel();
                will(returnValue(category.getLabel()));

                oneOf(mockQuestionDTO).toCategory();
                will(returnValue(category));
            }
        });
        expectedSaveCategory_whenDoesNotExists(category);
        return mockQuestionDTO;
    }

    private void expectedSaveCategory_whenDoesNotExists(Category category) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockCategoryRepository).findByLabel(category.getLabel());
                will(returnValue(Optional.ofNullable(null)));

                oneOf(mockCategoryRepository).save(category);
                will(returnValue(category));
            }
        });
    }

    @Test
    public void testCreateCategory_whenExists_shouldUpdateCategory() {
        Category category = createCategory();
        CategoryDTO categoryDTO = new CategoryDTOImpl(category);
        Category categoryFromDB = createCategoryFromDB(category);
        Category expectedCategory = createCategory();
        expectedCategory.setId(categoryFromDB.getId());
        expectedUpdateCategory_whenExists(categoryFromDB, expectedCategory);

        CategoryDTO actual = underTest.createCategory(categoryDTO);

        Assert.assertThat(actual.getId(), CoreMatchers.equalTo(expectedCategory.getId()));
        Assert.assertThat(actual.getLabel(), CoreMatchers.equalTo(expectedCategory.getLabel()));
        Assert.assertThat(actual.getBackgroundColor(), CoreMatchers.equalTo(expectedCategory.getBackgroundColor()));
        Assert.assertThat(actual.getBackgroundColor(), CoreMatchers.equalTo(expectedCategory.getBackgroundColor()));
    }

    private Category createCategoryFromDB(Category category) {
        Category categoryFromDB = new Category();
        categoryFromDB.setId(ObjectId.get());
        categoryFromDB.setLabel(category.getLabel());
        categoryFromDB.setBackgroundColor("#32a852");
        categoryFromDB.setColor("#c0c0c0");
        return categoryFromDB;
    }

    private void expectedUpdateCategory_whenExists(Category categoryFromDB, Category expectedCategory) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockCategoryRepository).findByLabel(expectedCategory.getLabel());
                will(returnValue(Optional.of(categoryFromDB)));

                expectedCategoryBuilderReturnSelf();
                oneOf(mockCategoryBuilder).build();
                will(returnValue(expectedCategory));

                oneOf(mockCategoryRepository).save(expectedCategory);
                will(returnValue(expectedCategory));
            }

            private void expectedCategoryBuilderReturnSelf() {
                oneOf(mockCategoryBuilder).id(expectedCategory.getId());
                will(returnValue(mockCategoryBuilder));
                oneOf(mockCategoryBuilder).label(expectedCategory.getLabel());
                will(returnValue(mockCategoryBuilder));
                oneOf(mockCategoryBuilder).backgroundColor(expectedCategory.getBackgroundColor());
                will(returnValue(mockCategoryBuilder));
                oneOf(mockCategoryBuilder).color(expectedCategory.getColor());
                will(returnValue(mockCategoryBuilder));
            }
        });
    }

    private CategoryDTO createCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTOImpl();
        categoryDTO.setLabel("history");
        categoryDTO.setBackgroundColor("#000000");
        categoryDTO.setColor("#000000");
        return categoryDTO;
    }

    private Category createCategory() {
        Category category = new Category("history", "#000000", "#ffffff");
        return category;
    }

    @Test
    public void testGetCategories() {
        Category category = createCategory();
        List<Category> expectedCategories = Arrays.asList(category);
        expectFindAll(expectedCategories);

        List<Category> actualCategories = underTest.getCategories();

        Assert.assertThat(actualCategories.size(), CoreMatchers.equalTo(expectedCategories.size()));
        Assert.assertThat(actualCategories.get(0), CoreMatchers.equalTo(category));
    }

    private void expectFindAll(List<Category> expectedCategories) {
        mockery.checking(new Expectations() {
            {
                oneOf(mockCategoryRepository).findAll();
                will(returnValue(expectedCategories));
            }
        });
    }
}