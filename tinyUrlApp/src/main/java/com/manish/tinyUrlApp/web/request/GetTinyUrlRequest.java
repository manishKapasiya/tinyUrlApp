package com.manish.tinyUrlApp.web.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class GetTinyUrlRequest {
    private String originalUrl;
    private Date expiryDate;
    private Long userId;
}
