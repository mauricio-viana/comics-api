package br.com.api.controllers.dto;

import br.com.api.models.Category;
import org.springframework.data.domain.Page;

public class CategoryDto {

    private Long id;
    private String title;
    private String color;
    private String description;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.color = category.getColor();
        this.description = category.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public static Page<CategoryDto> toConvert(Page<Category> categories) {
        return categories.map(CategoryDto::new);
    }

}
