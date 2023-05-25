package com.crud.CrudDemo.exception;

import com.crud.CrudDemo.entity.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Category not found")
public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(Long categoryId){
        super(String.valueOf(categoryId));
    }

    public CategoryNotFoundException(){};
}
