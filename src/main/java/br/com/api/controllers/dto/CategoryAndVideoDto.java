package br.com.api.controllers.dto;

import br.com.api.models.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryAndVideoDto {
    private Long id;
    private String title;
    private String color;
    private String description;
    private List<VideoDto> videos;

    public CategoryAndVideoDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.color = category.getColor();
        this.description = category.getDescription();
        this.videos = new ArrayList<>();
        this.videos.addAll(category.getVideos().stream().map(VideoDto::new).collect(Collectors.toList()));
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

    public List<VideoDto> getVideos() {
        return videos;
    }

    public static List<CategoryAndVideoDto> toConvert(List<Category> categories) {
        return categories.stream().map(CategoryAndVideoDto::new).collect(Collectors.toList());
    }

}
