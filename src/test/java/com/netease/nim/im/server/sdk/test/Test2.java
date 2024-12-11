package com.netease.nim.im.server.sdk.test;

import com.netease.nim.im.server.sdk.core.endpoint.DefaultRetryPolicy;
import com.netease.nim.im.server.sdk.core.endpoint.RetryPolicy;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test2 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        // 重试次数可以自定义
        int maxRetry = 1;
        // RetryPolicy可以自定义
        boolean retryOn502 = true;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(retryOn502);
        //
        YunxinV1ApiHttpClient client = new YunxinV1ApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .maxRetry(maxRetry)
                .retryPolicy(retryPolicy)
                .build();

        //
    }
}
