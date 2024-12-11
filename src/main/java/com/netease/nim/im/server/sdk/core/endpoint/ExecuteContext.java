package com.netease.nim.im.server.sdk.core.endpoint;

import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;

import java.util.Map;

/**
 * Created by caojiajun on 2024/12/9
 */
public class ExecuteContext {
    private final String endpoint;
    private final HttpMethod httpMethod;
    private final ContextType contextType;
    private final ApiVersion apiVersion;
    private final String uri;
    private final String path;
    private final Map<String, String> queryString;
    private final String data;
    private final String traceId;

    public ExecuteContext(String endpoint, HttpMethod httpMethod, ContextType contextType, ApiVersion apiVersion,
                          String uri, String path, Map<String, String> queryString, String data, String traceId) {
        this.endpoint = endpoint;
        this.httpMethod = httpMethod;
        this.contextType = contextType;
        this.apiVersion = apiVersion;
        this.uri = uri;
        this.path = path;
        this.queryString = queryString;
        this.data = data;
        this.traceId = traceId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public ContextType getContextType() {
        return contextType;
    }

    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public String getUri() {
        return uri;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getQueryString() {
        return queryString;
    }

    public String getData() {
        return data;
    }

    public String getTraceId() {
        return traceId;
    }
}
