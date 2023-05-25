package com.crud.CrudDemo.service;

import com.crud.CrudDemo.dto.request.CategoryRequest;
import com.crud.CrudDemo.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {


    CategoryResponse createCategory(CategoryRequest categoryRequest);

    List<CategoryRequest> getAllCategories();

    CategoryResponse getSingleCategory(Long categoryId);

    void deleteCategory(Long categoryId);

    CategoryResponse updateCategory(Long categoryId);
}
