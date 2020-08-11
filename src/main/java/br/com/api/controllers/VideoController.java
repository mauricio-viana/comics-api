package br.com.api.controllers;

import br.com.api.controllers.dto.VideoDto;
import br.com.api.controllers.form.VideoForm;
import br.com.api.models.Video;
import br.com.api.repository.CategoryRepository;
import br.com.api.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController  {

    private VideoRepository videoRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public VideoController(VideoRepository videoRepository, CategoryRepository categoryRepository) {
        this.videoRepository = videoRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VideoDto> create(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder){

        Video video = form.toConvert();
        videoRepository.save(video);

        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));
    }

}
