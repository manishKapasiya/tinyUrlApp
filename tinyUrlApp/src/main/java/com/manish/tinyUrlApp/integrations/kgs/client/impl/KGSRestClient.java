package com.manish.tinyUrlApp.integrations.kgs.client.impl;

import com.manish.tinyUrlApp.integrations.kgs.client.IKGSRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class KGSRestClient implements IKGSRestClient {

    @Value("${integration.kgs.url}")
    String kgsServiceUrl;

    @Value("${integration.kgs.getKey.path}")
    String getKeyPath;

    @Override
    public List<String> fetchKeysFromKGS() {
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(kgsServiceUrl).append(getKeyPath);
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(urlBuilder.toString(),List.class);
        return responseEntity.getBody();
    }
}
