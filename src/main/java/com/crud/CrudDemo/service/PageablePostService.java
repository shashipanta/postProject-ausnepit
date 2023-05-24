package com.crud.CrudDemo.service;

import com.crud.CrudDemo.dto.response.PostResponse;

import java.util.List;

public interface PageablePostService {

    List<PostResponse> getAllPosts();

    List<PostResponse> getThirdPageWithTwoPosts();
}