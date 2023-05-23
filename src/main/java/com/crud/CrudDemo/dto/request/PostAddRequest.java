package com.crud.CrudDemo.dto.request;

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
    private List<String> categories;

    public static Post postBuildFromRequest(PostAddRequest postAddRequest){
        return Post.builder()
                .id(null)
                .title(postAddRequest.getTitle())
                .description(postAddRequest.getDescription())
                .build();
    }

}
