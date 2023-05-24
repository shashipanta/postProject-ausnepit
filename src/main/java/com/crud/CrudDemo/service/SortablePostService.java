package com.crud.CrudDemo.service;

import com.crud.CrudDemo.dto.response.PostResponse;

import java.util.List;

public interface SortablePostService {

    List<PostResponse> getSortedPost();

    List<PostResponse> getPostSortedByTitle();

    List<PostResponse> getPostSortedByAttribute(String attributeName);

}
