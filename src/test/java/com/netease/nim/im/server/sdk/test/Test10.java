package com.netease.nim.im.server.sdk.test;

import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.endpoint.DynamicEndpointSelector;
import com.netease.nim.server.sdk.core.endpoint.LocalEndpointFetcher;

/**
 * Created by caojiajun on 2025/6/13
 */
public class Test10 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;

        String endpoint = "https://xxxx-01.com";
        String endpointBackUp = "https://xxxx-02.com";

        DynamicEndpointSelector endpointSelector = new DynamicEndpointSelector(BizName.IM, new LocalEndpointFetcher(endpoint, endpointBackUp));
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .endpointSelector(endpointSelector)
                .build();

        //
    }
}
