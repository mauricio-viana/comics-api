package br.com.api.controllers.form;

import br.com.api.models.Category;
import br.com.api.repository.CategoryRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateCategoryForm {
    @NotNull
    @NotEmpty
    private String title;

    @NotNull @NotEmpty
    private String color;

    @NotNull @NotEmpty
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category update(Long id, CategoryRepository categoryRepository) {
        Category category = categoryRepository.getOne(id);

        category.setTitle(this.title);
        category.setColor(this.color);
        category.setDescription(this.description);

        return category;
    }
}
