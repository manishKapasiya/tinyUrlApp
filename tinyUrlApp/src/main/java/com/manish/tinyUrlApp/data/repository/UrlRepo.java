package com.manish.tinyUrlApp.data.repository;

import com.manish.tinyUrlApp.data.entity.UrlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepo extends CrudRepository<UrlEntity, String> {

    Optional<UrlEntity> getUrlEntityByOriginalUrl(String originalUrl);
    Optional<UrlEntity> getUrlEntityByOriginalUrlAndUserId(String originalUrl, Long userId);
}
