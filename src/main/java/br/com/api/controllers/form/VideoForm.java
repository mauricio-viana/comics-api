package br.com.api.controllers.form;

import br.com.api.models.Category;
import br.com.api.models.Video;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VideoForm {

    private Category category;

    @NotNull @NotEmpty
    private String title;

    @NotNull @NotEmpty
    private String url;

    @NotNull @NotEmpty
    private String description;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Video toConvert() {
        return new Video( this.category, this.title, this.url, this.description );
    }
}
