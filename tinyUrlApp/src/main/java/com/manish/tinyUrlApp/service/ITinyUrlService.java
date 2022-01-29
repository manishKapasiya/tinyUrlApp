package com.manish.tinyUrlApp.service;

import com.manish.tinyUrlApp.exceptions.CreateTinyUrlException;
import com.manish.tinyUrlApp.web.request.GetTinyUrlRequest;

public interface ITinyUrlService {

    String getTinyUrl(GetTinyUrlRequest request) throws CreateTinyUrlException;
}
