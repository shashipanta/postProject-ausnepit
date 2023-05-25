package com.crud.CrudDemo.controller;

import com.crud.CrudDemo.dto.CustomMessage;
import com.crud.CrudDemo.dto.request.CategoryRequest;
import com.crud.CrudDemo.dto.response.CategoryResponse;
import com.crud.CrudDemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // create category

    @PostMapping(value = "/")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }

    // localhost:8080/api/categories/
    @GetMapping("/")
    public List<CategoryResponse> getAllCategory(){
        return categoryService.getAllCategories();
    }

    // localhost:8080/api/categories/{id}
    @PutMapping("/{id}")
    public CategoryResponse updateCategoryById(@PathVariable("id") Long categoryId,
                                               @RequestBody(required = true) CategoryRequest categoryRequest){
        return categoryService.updateCategory(categoryId, categoryRequest);
    }

    // localhost:8080/api/categories/{id}
    @DeleteMapping(value = "/{id}")
    public CustomMessage deleteCategory(@PathVariable("id") Long categoryId){
        return categoryService.deleteCategoryById(categoryId);
    }


}
