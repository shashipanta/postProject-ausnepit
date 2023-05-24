package com.crud.CrudDemo.service;

import com.crud.CrudDemo.dto.CustomMessage;
import com.crud.CrudDemo.dto.request.PostAddRequest;
import com.crud.CrudDemo.dto.request.PostUpdateRequest;
import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.dto.response.PostUpdateResponse;

import java.util.List;

public interface PostService {

    PostResponse createPost(PostAddRequest request);
    PostResponse getSinglePost(Long postId);
    List<PostResponse> getAllPost();
    PostUpdateResponse updatePost(Long postId, PostUpdateRequest postUpdateRequest);
    void deletePost(Long postId);


    // pagination
    List<PostResponse> getFirstPageSortedByPostTitle();

}
