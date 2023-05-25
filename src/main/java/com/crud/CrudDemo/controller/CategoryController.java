package com.crud.CrudDemo.controller;

import com.crud.CrudDemo.dto.request.CategoryRequest;
import com.crud.CrudDemo.dto.response.CategoryResponse;
import com.crud.CrudDemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    // create category

    @PostMapping(value = "/")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }


}
