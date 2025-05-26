package com.netease.nim.im.server.sdk.test;

import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2025/5/26
 */
public class YunxinApiHttpClientInit {

    private static YunxinApiHttpClient yunxinApiHttpClient;

    public static YunxinApiHttpClient init() {
        if (yunxinApiHttpClient != null) {
            return yunxinApiHttpClient;
        }
        String appkey = System.getProperty("appkey");
        String appsecret = System.getProperty("appsecret");
        if (appkey == null) {
            appkey = System.getenv("appkey");
        }
        if (appsecret == null) {
            appsecret = System.getenv("appsecret");
        }
        if (appkey == null || appsecret == null) {
            System.out.println("appkey not found");
            return null;
        }
        int timeoutMillis = 5000;
        yunxinApiHttpClient = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();
        return yunxinApiHttpClient;
    }
}
