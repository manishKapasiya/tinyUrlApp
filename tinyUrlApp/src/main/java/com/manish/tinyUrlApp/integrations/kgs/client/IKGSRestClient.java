package com.manish.tinyUrlApp.integrations.kgs.client;

import java.util.List;

public interface IKGSRestClient {
    List<String> fetchKeysFromKGS();
}
