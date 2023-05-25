package com.crud.CrudDemo.dto.response;

import com.crud.CrudDemo.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {

    private Long id;
    private String name;
    private String description;

    public static CategoryResponse prepareCategoryResponse(Category category){

        return CategoryResponse.builder()
                                .id(category.getId())
                                .name(category.getName())
                                .description(category.getDescription())
                                .build();
    }
}
