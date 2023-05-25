package com.crud.CrudDemo.exception;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlers {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handlePostNotFoundException(final PostNotFoundException exception){

        logger.error("Post with id {} was not found", 1);
        return new ErrorResponse("POST_NOT_FOUND", "Post was not found");
    }

//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorResponse handleInternalServerError(final Throwable ex){
//        logger.error("Internal Server Error");
//        ex.printStackTrace();
//        return new ErrorResponse("INTERNAL_SERVER_ERROR", "Something went wrong in server");
//    }

    @ExceptionHandler(PageNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handlePageNotValidException(final PageNotValidException pageNotValidException){
        logger.error("Page with pageNumber {} was not found", pageNotValidException.getMessage());
        return new ErrorResponse("PAGE_NOT_VALID", "Page Number is not valid");
    }


    // Attribute not found during sorting operation
    @ExceptionHandler(AttributeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleAttributeNotFoundException(final AttributeNotFoundException attributeNotFoundException){
        logger.error("Post does not have attribute named : {}", attributeNotFoundException.getMessage());
        return new ErrorResponse("ATTRIBUTE_NOT_FOUND", "Attribute is invalid");
    }


}
