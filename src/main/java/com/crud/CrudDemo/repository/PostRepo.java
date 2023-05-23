package com.crud.CrudDemo.repository;

import com.crud.CrudDemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
