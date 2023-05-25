package com.crud.CrudDemo.dto.request;

import com.crud.CrudDemo.entity.Category;
import com.crud.CrudDemo.entity.Post;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryRequest {

    private Long id;
    private String name;
    private String description;
    private Post post;

    public static Category prepareCategory(CategoryRequest categoryRequest){
        return Category.builder()
                        .id(categoryRequest.getId())
                        .name(categoryRequest.getName())
                        .description(categoryRequest.getDescription())
                        .build();
    }
}
