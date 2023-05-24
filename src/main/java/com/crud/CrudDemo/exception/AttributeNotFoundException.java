package com.crud.CrudDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Attribute not found")
public class AttributeNotFoundException extends RuntimeException{

    public AttributeNotFoundException(String attributeName){
        super(attributeName);
    }
}
