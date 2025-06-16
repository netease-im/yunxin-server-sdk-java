package com.netease.nim.server.sdk.meeting;

import com.netease.nim.server.sdk.core.Result;

/**
 * Created by caojiajun on 2025/6/12
 */
public class MeetingResult<T> extends Result<T> {

    private final String requestId;
    private final long ts;
    private final String cost;

    public MeetingResult(String endpoint, int code, String traceId, String requestId,
                         long ts, String cost, String msg, T response) {
        super(endpoint, code, traceId, msg, response);
        this.requestId = requestId;
        this.ts = ts;
        this.cost = cost;
    }

    public boolean isSuccess() {
        return getCode() == 0;
    }

    public String getRequestId() {
        return requestId;
    }

    public long getTs() {
        return ts;
    }

    public String getCost() {
        return cost;
    }
}
