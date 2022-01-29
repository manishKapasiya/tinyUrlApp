package com.manish.tinyUrlApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class CreateTinyUrlException  extends RuntimeException{
    private String errorMessage;
    private String errorCode;
    private HttpStatus httpStatus;
}
