package com.crud.CrudDemo.repository;

import com.crud.CrudDemo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableAndSortablePostRepo extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);
}
