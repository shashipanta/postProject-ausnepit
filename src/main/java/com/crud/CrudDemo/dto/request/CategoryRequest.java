package com.crud.CrudDemo.dto.request;

import com.crud.CrudDemo.entity.Category;
import com.crud.CrudDemo.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CategoryRequest {

    private String name;
    private String description;

    public static Category prepareCategory(CategoryRequest categoryRequest){

        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        return category;
    }
}
