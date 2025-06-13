package com.netease.nim.server.sdk.core;


import com.netease.nim.server.sdk.core.endpoint.RetryPolicy;

/**
 * Created by caojiajun on 2025/6/4
 */
public enum BizName {
    IM(1, true, Constants.Retry.retryOn502, "/health/liveness.action"),//即时通讯
    RTC(2, false, Constants.Retry.notRetryOn502, "/index.html"),//实时音视频
    SMS(3, true, Constants.Retry.notRetryOn502, "/health/liveness.action"),//短信
    LIVE(4, true, Constants.Retry.retryOn502, "/health/status"),//直播
    VOD(5, true, Constants.Retry.retryOn502, "/health/status"),//点播
    MEETING(6, true, Constants.Retry.retryOn502, "/status.html"),//会议
    NEROOM(7, true, Constants.Retry.retryOn502, "/status.html"),//neroom
    CUSTOM(1000, false, Constants.Retry.notRetryOn502, null),//自定义
    ;
    //枚举值
    private final int value;
    //api域名是否总是返回200
    //如果是则非200返回将通过异常上抛
    //否则不做异常上抛，而是在response中返回httpCode，由上层自行处理
    private final boolean httpCodeAlways200;
    //默认重试策略
    private final RetryPolicy defaultRetryPolicy;
    //api域名的探测接口
    private final String detectPath;

    BizName(int value, boolean httpCodeAlways200, RetryPolicy defaultRetryPolicy, String detectPath) {
        this.value = value;
        this.httpCodeAlways200 = httpCodeAlways200;
        this.defaultRetryPolicy = defaultRetryPolicy;
        this.detectPath = detectPath;
    }

    public int getValue() {
        return value;
    }

    public boolean isHttpCodeAlways200() {
        return httpCodeAlways200;
    }

    public RetryPolicy getDefaultRetryPolicy() {
        return defaultRetryPolicy;
    }

    public String getDetectPath() {
        return detectPath;
    }
}
