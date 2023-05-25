package com.crud.CrudDemo.service.serviceImpl;

import com.crud.CrudDemo.dto.CustomMessage;
import com.crud.CrudDemo.dto.request.CategoryRequest;
import com.crud.CrudDemo.dto.response.CategoryResponse;
import com.crud.CrudDemo.entity.Category;
import com.crud.CrudDemo.exception.CategoryNotFoundException;
import com.crud.CrudDemo.repository.CategoryRepo;
import com.crud.CrudDemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<CategoryResponse> getAllCategories() {

        List<Category> categoryList = categoryRepo.findAll();
        List<CategoryResponse> categoryResponseList =
                categoryList.stream()
                    .map(CategoryResponse::prepareCategoryResponse)
                    .collect(Collectors.toList());
        return categoryResponseList;
    }

    @Override
    public CategoryResponse getSingleCategory(Long categoryId) {
        return null;
    }

    @Override
    public CustomMessage deleteCategoryById(Long categoryId) {
        categoryRepo.deleteById(categoryId);

        Optional<Category> category = categoryRepo.findById(categoryId);

        if(!category.isPresent()){
            return new CustomMessage("Category deleted successfully");
        }

        return new CustomMessage("Category Id is invalid / not found");

    }

    @Override
    public CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest) {

        Category foundCategory = categoryRepo.findById(categoryId).orElseThrow(CategoryNotFoundException::new);

        foundCategory = prepareCategoryToUpdate(categoryRequest, foundCategory);

        foundCategory =  categoryRepo.save(foundCategory);

        return CategoryResponse.prepareCategoryResponse(foundCategory);
    }


    private Category prepareCategoryToSave(CategoryRequest categoryRequest){
        Category category = new Category();

        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        return category;
    }

    private Category prepareCategoryToUpdate(CategoryRequest categoryRequest, Category foundCategory){

        if(categoryRequest.getName() != null) foundCategory.setName(categoryRequest.getName());
        if(categoryRequest.getDescription() != null) foundCategory.setDescription(categoryRequest.getDescription());

        return foundCategory;
    }
}
