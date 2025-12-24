package com.netease.nim.server.sdk.core.endpoint;

import okhttp3.OkHttpClient;

import java.util.Set;

/**
 * Created by caojiajun on 2024/12/9
 */
public interface EndpointSelector {

    void init(OkHttpClient okHttpClient);

    void update(String endpoint, RequestResult result);

    String selectEndpoint(Set<String> excludeEndpoints);

    default void shutdown() {

    }
}
