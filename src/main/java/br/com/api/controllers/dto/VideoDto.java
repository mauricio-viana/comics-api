package br.com.api.controllers.dto;

import br.com.api.models.Video;
import org.springframework.data.domain.Page;

public class VideoDto {

    private Long id;
    private String title;
    private String url;
    private String description;

    public VideoDto(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.url = video.getUrl();
        this.description = video.getDescription();
    }

    public static Page<VideoDto> toConvert(Page<Video> videos) {
        return videos.map(VideoDto::new);
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
}
