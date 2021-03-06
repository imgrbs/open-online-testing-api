package online.testing.exam.dto;

import online.testing.exam.dto.impl.CategoryDTOImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CategoryDTOImplTest {
    @Test
    void testCreateCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTOImpl();

        Assert.assertThat(categoryDTO.getLabel(), CoreMatchers.nullValue());
        Assert.assertThat(categoryDTO.getBackgroundColor(), CoreMatchers.nullValue());
        Assert.assertThat(categoryDTO.getColor(), CoreMatchers.nullValue());
    }

}
