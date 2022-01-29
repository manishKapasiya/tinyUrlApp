package com.manish.tinyUrlApp.constants;

import org.springframework.http.HttpStatus;

public class ServiceErrors {

    public static final String USER_DOES_NOT_EXIST_ERROR_CODE = "1001";
    public static final String USER_DOES_NOT_EXIST_ERROR_MESSAGE = "User with given id does not exist";
    public static final HttpStatus USER_DOES_NOT_EXIST_HTTP_STATUS = HttpStatus.UNAUTHORIZED;

    public static final String URL_MAPPING_ALREADY_EXIST_ERROR_CODE = "1002";
    public static final String URL_MAPPING_ALREADY_EXIST_ERROR_MESSAGE = "Url mapping for this url already exist";
    public static final HttpStatus URL_MAPPING_ALREADY_EXIST_HTTP_STATUS = HttpStatus.CONFLICT;

}
