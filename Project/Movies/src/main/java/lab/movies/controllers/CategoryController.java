package lab.movies.controllers;


import lab.movies.models.Category;
import lab.movies.models.Movie;
import lab.movies.repositories.CategoryRepository;
import lab.movies.repositories.MovieRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
