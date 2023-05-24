package com.crud.CrudDemo.repository;

import com.crud.CrudDemo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PageableAndSortablePostRepo extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    List<Post> findPostByTitle(String postTitle, Pageable pageable);


}
