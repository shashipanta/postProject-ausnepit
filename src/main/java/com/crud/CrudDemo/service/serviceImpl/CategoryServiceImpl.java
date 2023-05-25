package com.crud.CrudDemo.service.serviceImpl;

import com.crud.CrudDemo.dto.request.CategoryRequest;
import com.crud.CrudDemo.dto.response.CategoryResponse;
import com.crud.CrudDemo.entity.Category;
import com.crud.CrudDemo.repository.CategoryRepo;
import com.crud.CrudDemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = CategoryRequest.prepareCategory(categoryRequest);

         category = categoryRepo.save(category);

        return CategoryResponse.prepareCategoryResponse(category);
    }

    @Override
    public List<CategoryRequest> getAllCategories() {
        return null;
    }

    @Override
    public CategoryResponse getSingleCategory(Long categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    @Override
    public CategoryResponse updateCategory(Long categoryId) {
        return null;
    }
}
