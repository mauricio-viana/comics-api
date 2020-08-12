package br.com.api.controllers;

import br.com.api.controllers.dto.VideoCategoryDto;
import br.com.api.controllers.dto.VideoDto;
import br.com.api.controllers.form.VideoForm;
import br.com.api.models.Video;
import br.com.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController  {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<VideoDto> create(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder){

        Video video = form.toConvert();
        videoRepository.save(video);

        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));
    }

    @GetMapping
    public Page<VideoCategoryDto> getAll(@RequestParam(required = false) String title,
                                         @PageableDefault(sort = "categoryTitle", direction = Sort.Direction.ASC) Pageable pagination) {

        if (title == null){
            Page<Video> videos = videoRepository.findAll(pagination);
            return VideoCategoryDto.toConvert(videos);
        }
        Page<Video> videos = videoRepository.findByTitle(title, pagination);
        return VideoCategoryDto.toConvert(videos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove (@PathVariable Long id){
        Optional<Video> video = videoRepository.findById(id);

        if (video.isPresent()){
            videoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VideoDto> update(@PathVariable Long id, @RequestBody @Valid VideoForm form){
        Optional<Video> optional = videoRepository.findById(id);
        if (optional.isPresent()){
            Video video = form.update(id, videoRepository);
            return ResponseEntity.ok(new VideoDto(video));
        }
        return ResponseEntity.notFound().build();
    }
}
