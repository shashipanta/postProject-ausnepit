package com.crud.CrudDemo.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostUpdateRequest {
    
    private Long id;
    private String title;
    private String description;

}
