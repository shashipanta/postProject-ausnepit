package com.crud.CrudDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.crud.CrudDemo.exception.PostNotFoundException;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handlePostNotFoundException(final PostNotFoundException exception){
        return new ErrorResponse("POST_NOT_FOUND", "Post was not found");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalServerError(final Throwable ex){
        return new ErrorResponse("INTERNAL_SERVER_ERROR", "Something went wrong in server");
    }


}
