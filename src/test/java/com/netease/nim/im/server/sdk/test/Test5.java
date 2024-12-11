package com.netease.nim.im.server.sdk.test;

import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test5 {
    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;

        String endpoint = "https://xxxx.com";
        //
        YunxinV1ApiHttpClient client = new YunxinV1ApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .endpoint(endpoint)
                .build();

        //
    }
}
