package com.netease.nim.server.sdk.core;


import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.http.ContextType;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.http.HttpResponse;
import com.netease.nim.server.sdk.core.metrics.Stats;
import com.netease.nim.server.sdk.core.trace.ApiVersion;

import java.util.Map;

/**
 * Created by caojiajun on 2024/11/27
 */
public interface HttpClient {

    /**
     * execute http request
     * @param method http method
     * @param contextType content-type
     * @param apiVersion api-version
     * @param uri uri, only for metrics
     * @param path path
     * @param queryString query string
     * @param data data
     * @return http response
     * @throws YunxinSdkException exception
     */
    HttpResponse execute(HttpMethod method, ContextType contextType, ApiVersion apiVersion,
                         String uri, String path, Map<String, String> queryString, String data) throws YunxinSdkException;

    Stats getStats();
}
