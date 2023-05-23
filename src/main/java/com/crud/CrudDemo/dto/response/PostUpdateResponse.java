package com.crud.CrudDemo.dto.response;


import com.crud.CrudDemo.entity.Post;
import com.crud.CrudDemo.utils.DateTimeToString;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostUpdateResponse {

    private Long id;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;


    public static PostUpdateResponse postUpdateResponseBuilder(Post post){
        return PostUpdateResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .updatedAt(DateTimeToString.localDateTimeToString(post.getUpdatedAt()))
                .createdAt(DateTimeToString.localDateTimeToString(post.getCreatedAt()))
                .build();
    }
}
