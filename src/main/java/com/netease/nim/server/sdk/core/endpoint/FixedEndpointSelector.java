package com.netease.nim.server.sdk.core.endpoint;

import okhttp3.OkHttpClient;

import java.util.Set;

/**
 * Created by caojiajun on 2024/12/9
 */
public class FixedEndpointSelector implements EndpointSelector {

    private final String endpoint;

    public FixedEndpointSelector(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void init(OkHttpClient okHttpClient) {

    }

    @Override
    public void update(String endpoint, RequestResult result) {

    }

    @Override
    public String selectEndpoint(Set<String> excludeEndpoints) {
        return endpoint;
    }
}
