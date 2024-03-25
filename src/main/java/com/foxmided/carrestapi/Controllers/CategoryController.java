package com.foxmided.carrestapi.Controllers;


import com.foxmided.carrestapi.Model.Category;
import com.foxmided.carrestapi.Service.CarService;
import com.foxmided.carrestapi.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CarService carService;

    public CategoryController(CategoryService categoryService, CarService carService) {
        this.categoryService = categoryService;
        this.carService = carService;
    }
    @Operation(summary = "Home page")
    @GetMapping("")
    public List<Category> getAllCategory(){
        return categoryService.getAll();
    }

    @Operation(summary = "find category by id")
    @GetMapping("/find/{id}")
    public Category findCategoryById(@RequestParam("id") Integer id){
        return categoryService.getByCategoryId(id);
    }
    @Operation(summary = "add new category")
    @PostMapping("/save")
    public void saveCategory(@RequestBody Category category){
        categoryService.save(category);
    }
    @Operation(summary = "delete category by id")
    @PostMapping("/delete/{id}")
    public void deleteCategory(@RequestParam("id") Integer id){
        categoryService.delete(id);
    }
}
