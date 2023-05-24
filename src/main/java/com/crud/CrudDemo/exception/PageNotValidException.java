package com.crud.CrudDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Page Number is not valid")
public class PageNotValidException extends RuntimeException{
}
