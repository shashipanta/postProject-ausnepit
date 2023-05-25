package com.crud.CrudDemo.repository;

import com.crud.CrudDemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.isDeleted = false")
    List<Post> findAllPost();

    Post findPostByIdAndAndIsDeleted(Long id, Boolean isDeleted);

//    Post findPostByIdAndIsDeletedNotIn(Long id);
}
