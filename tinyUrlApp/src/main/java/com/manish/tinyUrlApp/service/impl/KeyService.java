package com.manish.tinyUrlApp.service.impl;

import com.manish.tinyUrlApp.integrations.kgs.client.impl.KGSRestClient;
import com.manish.tinyUrlApp.service.IKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyService implements IKeyService {

    KGSRestClient kgsRestClient;

    public KeyService(@Autowired KGSRestClient kgsRestClient){
        this.kgsRestClient = kgsRestClient;
    }

    @Override
    public String getKey() {
        // return a key from cache,
        // if exhausted refill cache from KGS and return a key
        List<String> keys = kgsRestClient.fetchKeysFromKGS();
        return keys.get(0);
    }
}
