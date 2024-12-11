package com.netease.nim.im.server.sdk.core;


import com.netease.nim.im.server.sdk.core.exception.YunxinSdkIOException;
import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.http.HttpResponse;
import com.netease.nim.im.server.sdk.core.metrics.Stats;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;

/**
 * Created by caojiajun on 2024/11/27
 */
public interface HttpClient {

    HttpResponse execute(HttpMethod method, ContextType contextType, ApiVersion apiVersion, String uri, String path, String data) throws YunxinSdkIOException;

    Stats getStats();
}
