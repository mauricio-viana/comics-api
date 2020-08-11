package br.com.api.controllers;

import br.com.api.controllers.dto.CategoryDto;
import br.com.api.controllers.dto.CategoryAndVideoDto;
import br.com.api.controllers.form.CategoryForm;
import br.com.api.controllers.form.UpdateCategoryForm;
import br.com.api.models.Category;
import br.com.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Page<CategoryDto> getAll(@RequestParam(required = false) String title,
                                    @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pagination) {

        if (title == null){
            Page<Category> categories = categoryRepository.findAll(pagination);
            return CategoryDto.toConvert(categories);
        }
        Page<Category> categories = categoryRepository.findByTitle(title, pagination);
        return CategoryDto.toConvert(categories);
    }

    @GetMapping("/videos")
    public List<CategoryAndVideoDto> getAllWithVideos(){
        List<Category> categories = categoryRepository.findAll();
        return CategoryAndVideoDto.toConvert(categories);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder){
        Category category = form.toConvert();
        categoryRepository.save(category);

        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryDto(category));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody @Valid UpdateCategoryForm form){
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            Category category = form.update(id, categoryRepository);
            return ResponseEntity.ok(new CategoryDto(category));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove (@PathVariable Long id){
        Optional<Category> optional = categoryRepository.findById(id);

        if(optional.isPresent()){
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}