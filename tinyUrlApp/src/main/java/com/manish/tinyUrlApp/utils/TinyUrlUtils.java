package com.manish.tinyUrlApp.utils;

import java.net.URL;

public class TinyUrlUtils {

    public static String buildTinyUrl(String originalUrl, String tinyUrlKey){
        try {
            URL url = new URL(originalUrl);
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();

            StringBuilder builder = new StringBuilder();
            builder.append(protocol).
                    append("://").
                    append(host).append(":").append(port).
                    append("/").
                    append(tinyUrlKey);

            return builder.toString();
        }catch (Exception e){
            return null;
        }
    }
}
