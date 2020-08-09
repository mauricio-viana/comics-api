package br.com.api.controllers.dto;

import br.com.api.models.Category;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<CategoryDto> toConvert(List<Category> categories) {
        return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }
}
