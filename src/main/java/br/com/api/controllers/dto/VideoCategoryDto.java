package br.com.api.controllers.dto;

import br.com.api.models.Video;
import org.springframework.data.domain.Page;

public class VideoCategoryDto {

    private Long id;
    private String title;
    private String url;
    private String description;
    private Long categoryId;
    private String categoryTitle;

    public VideoCategoryDto(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.url = video.getUrl();
        this.description = video.getDescription();
        this.categoryId = video.getCategory().getId();
        this.categoryTitle = video.getCategory().getTitle();
    }

    public static Page<VideoCategoryDto> toConvert(Page<Video> videos) {
        return videos.map(VideoCategoryDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
