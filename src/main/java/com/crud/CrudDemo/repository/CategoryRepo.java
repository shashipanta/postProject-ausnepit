package com.crud.CrudDemo.repository;

import com.crud.CrudDemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
