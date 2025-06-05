package com.netease.nim.server.sdk.core.trace;


/**
 * Created by caojiajun on 2025/2/10
 */
public class TimeoutSetter {

    private static final ThreadLocal<Long> timeout = new ThreadLocal<>();

    public static Long getAndClear() {
        Long timeoutMillis = timeout.get();
        timeout.remove();
        return timeoutMillis;
    }

    public static void setTimeout(long timeoutMillis) {
        timeout.set(timeoutMillis);
    }

}
