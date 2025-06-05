package com.netease.nim.server.sdk.core.endpoint;


import okhttp3.OkHttpClient;

/**
 * Created by caojiajun on 2024/12/9
 */
public interface EndpointFetcher {

    void init(OkHttpClient okHttpClient);

    Endpoints get();

}
