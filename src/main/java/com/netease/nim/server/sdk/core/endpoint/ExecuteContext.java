package com.netease.nim.server.sdk.core.endpoint;

import com.netease.nim.server.sdk.core.http.ContextType;
import com.netease.nim.server.sdk.core.http.HttpMethod;
import com.netease.nim.server.sdk.core.trace.ApiVersion;
import com.netease.nim.server.sdk.core.BizName;

import java.util.Map;

/**
 * Created by caojiajun on 2024/12/9
 */
public class ExecuteContext {
    private final BizName bizName;
    private final String endpoint;
    private final HttpMethod httpMethod;
    private final ContextType contextType;
    private final ApiVersion apiVersion;
    private final String uri;
    private final String path;
    private final Map<String, String> queryString;
    private final String data;
    private final String traceId;

    public ExecuteContext(BizName bizName, String endpoint, HttpMethod httpMethod, ContextType contextType, ApiVersion apiVersion,
                          String uri, String path, Map<String, String> queryString, String data, String traceId) {
        this.bizName = bizName;
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

    public BizName getBizName() {
        return bizName;
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
