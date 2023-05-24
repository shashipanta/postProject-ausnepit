package com.crud.CrudDemo.dto.response;

import com.crud.CrudDemo.entity.Post;
import com.crud.CrudDemo.utils.DateTimeToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private Long id;
    private String title;
    private String description;
    private List<String> categories;
    private String createdAt;
    private String updatedAt;

    public static PostResponse preparePostResponse(Post post){
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .createdAt(DateTimeToString.localDateTimeToString(post.getCreatedAt()))
                .updatedAt(DateTimeToString.localDateTimeToString(post.getUpdatedAt()))
                .build();
    }

}
