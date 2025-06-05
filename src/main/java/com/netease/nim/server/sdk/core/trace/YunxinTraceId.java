package com.netease.nim.server.sdk.core.trace;

/**
 * Created by caojiajun on 2024/12/9
 */
public class YunxinTraceId {

    private static final ThreadLocal<String> traceThreadLocal = new ThreadLocal<>();

    /**
     * 获取trace-id
     * @return trace-id
     */
    public static String get() {
        return traceThreadLocal.get();
    }

    /**
     * 设置trace-id
     * @param traceId trace-id
     */
    public static void set(String traceId) {
        traceThreadLocal.set(traceId);
    }

    /**
     * 清空trace-id
     */
    public static void clear() {
        traceThreadLocal.remove();
    }
}
