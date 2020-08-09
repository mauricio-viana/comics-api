package br.com.api.controllers.form;

import br.com.api.models.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryForm {

    @NotNull @NotEmpty
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

    public Category toConvert() {
        return new Category(this.title, this.color, this.description);
    }
}
