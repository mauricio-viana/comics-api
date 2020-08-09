package br.com.api.controllers;

import br.com.api.controllers.dto.CategoryDto;
import br.com.api.models.Category;
import br.com.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return CategoryDto.toConvert(categories);
    }
}