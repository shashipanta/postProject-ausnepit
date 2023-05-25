package com.crud.CrudDemo.service;

import com.crud.CrudDemo.dto.CustomMessage;
import com.crud.CrudDemo.dto.request.CategoryRequest;
import com.crud.CrudDemo.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {


    CategoryResponse createCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getSingleCategory(Long categoryId);

    CustomMessage deleteCategoryById(Long categoryId);

    CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest);
}
