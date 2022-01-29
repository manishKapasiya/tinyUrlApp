package com.manish.tinyUrlApp.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CreateTinyUrlException.class)
    public ResponseEntity<Object> exception(CreateTinyUrlException  exception) {
        ErrorObject object = new ErrorObject(exception.getErrorCode(),exception.getErrorMessage());
        return new ResponseEntity(object, exception.getHttpStatus());
    }

}
