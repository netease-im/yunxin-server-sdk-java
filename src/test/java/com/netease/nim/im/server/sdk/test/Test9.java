package com.netease.nim.im.server.sdk.test;

import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.endpoint.Region;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test9 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .region(Region.SG)//限制调度服务域名的地区，默认可以不填
                .build();
    }
}
