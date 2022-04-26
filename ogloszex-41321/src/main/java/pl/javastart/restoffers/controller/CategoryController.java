package pl.javastart.restoffers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.model.CategoryDto;
import pl.javastart.restoffers.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/names")
    public List<String> findCategoryNames() {
        return categoryService.findNames();
    }


}
