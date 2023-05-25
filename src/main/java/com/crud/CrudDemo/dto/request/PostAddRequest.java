package com.crud.CrudDemo.dto.request;

import com.crud.CrudDemo.entity.Category;
import com.crud.CrudDemo.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostAddRequest {

    private String title;
    private String description;

    public static Post postBuildFromRequest(PostAddRequest postAddRequest){
        Post post =  Post.builder()
                .title(postAddRequest.getTitle())
                .description(postAddRequest.getDescription())
                .isDeleted(false)
                .build();
        return post;
    }

}
