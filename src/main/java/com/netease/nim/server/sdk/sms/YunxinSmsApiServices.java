package com.netease.nim.server.sdk.sms;


import com.netease.nim.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2025/6/12
 */
public class YunxinSmsApiServices {
    private final ISmsApiService smsApiService;

    public YunxinSmsApiServices(YunxinApiHttpClient yunxinApiHttpClient) {
        smsApiService = new SmsApiService(yunxinApiHttpClient);
    }

    public ISmsApiService getSmsApiService() {
        return smsApiService;
    }
}


