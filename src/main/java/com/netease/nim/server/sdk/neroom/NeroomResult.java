package com.netease.nim.server.sdk.neroom;

import com.netease.nim.server.sdk.core.Result;

/**
 * Created by caojiajun on 2025/6/12
 */
public class NeroomResult<T> extends Result<T> {

    private final String requestId;
    private final long ts;
    private final long cost;

    public NeroomResult(String endpoint, int code, String traceId, String requestId,
                         long ts, long cost, String msg, T response) {
        super(endpoint, code, traceId, msg, response);
        this.requestId = requestId;
        this.ts = ts;
        this.cost = cost;
    }

    public String getRequestId() {
        return requestId;
    }

    public long getTs() {
        return ts;
    }

    public long getCost() {
        return cost;
    }
}
