package com.manish.tinyUrlApp.service.impl;

import com.manish.tinyUrlApp.data.entity.UrlEntity;
import com.manish.tinyUrlApp.data.entity.User;
import com.manish.tinyUrlApp.data.repository.UrlRepo;
import com.manish.tinyUrlApp.exceptions.CreateTinyUrlException;
import com.manish.tinyUrlApp.service.IKeyService;
import com.manish.tinyUrlApp.service.ITinyUrlService;
import com.manish.tinyUrlApp.service.IUserService;
import com.manish.tinyUrlApp.utils.TinyUrlUtils;
import com.manish.tinyUrlApp.web.request.GetTinyUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.manish.tinyUrlApp.constants.ServiceErrors.*;

@Service
public class TinyUrlService implements ITinyUrlService {

    private IKeyService keyService;
    private UrlRepo urlRepo;
    private IUserService userService;

    public TinyUrlService(@Autowired IKeyService keyService,
                          @Autowired UrlRepo urlRepo,
                          @Autowired IUserService userService){
        this.keyService = keyService;
        this.urlRepo = urlRepo;
        this.userService = userService;
    }

    @Override
    public String getTinyUrl(GetTinyUrlRequest request) throws CreateTinyUrlException {

        userWithIdExistCheck(request.getUserId());
        urlMappingExistCheck(request.getOriginalUrl(),request.getUserId());

        // get a new key for this original url from cache or KGS
        String tinyUrlKey = keyService.getKey();

        // update the database with the new url mapping
        UrlEntity urlEntity = createUrlEntity(request, tinyUrlKey);
        urlRepo.save(urlEntity);

        // build tiny url with replaced key
        String tinyUrl = TinyUrlUtils.buildTinyUrl(request.getOriginalUrl(),tinyUrlKey);
        return tinyUrl;
    }

    private UrlEntity createUrlEntity(GetTinyUrlRequest request, String tinyUrlKey){
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setOriginalUrl(request.getOriginalUrl());
        urlEntity.setExpiryDate(request.getExpiryDate());
        urlEntity.setUserId(request.getUserId());
        urlEntity.setKey(tinyUrlKey);
        return urlEntity;
    }

    private void userWithIdExistCheck(Long userId){
        Optional<User> userOptional = userService.getUser(userId);
        if (userOptional.isEmpty()){
            throw new CreateTinyUrlException(USER_DOES_NOT_EXIST_ERROR_MESSAGE,
                    USER_DOES_NOT_EXIST_ERROR_CODE,
                    USER_DOES_NOT_EXIST_HTTP_STATUS);
        }
    }

    private void urlMappingExistCheck(String originalUrl, Long userId){
        Optional<UrlEntity> urlEntityOptional = urlRepo.
                getUrlEntityByOriginalUrlAndUserId(originalUrl,
                        userId);
        if(urlEntityOptional.isPresent()){
            throw new CreateTinyUrlException(URL_MAPPING_ALREADY_EXIST_ERROR_MESSAGE,
                    URL_MAPPING_ALREADY_EXIST_ERROR_CODE,
                    URL_MAPPING_ALREADY_EXIST_HTTP_STATUS);
        }
    }

}
