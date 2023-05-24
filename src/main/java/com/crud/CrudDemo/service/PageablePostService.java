package com.crud.CrudDemo.service;

import com.crud.CrudDemo.dto.response.PostResponse;
import com.crud.CrudDemo.entity.Post;

import java.util.List;

public interface PageablePostService {

    List<PostResponse> getAllPosts();

    List<PostResponse> getThirdPageWithTwoPosts();

    List<PostResponse> getPostByPostTitle(String postTitle);

    List<PostResponse> getPostsByOffset(Integer pageNumber);
}
