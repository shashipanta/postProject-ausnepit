package com.crud.CrudDemo.dto.request;

import com.crud.CrudDemo.dto.response.PostUpdateResponse;
import com.crud.CrudDemo.utils.DateTimeToString;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostUpdateRequest {
    
    private Long id;
    private String title;
    private String description;

}
