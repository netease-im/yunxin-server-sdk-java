package com.netease.nim.server.sdk.core.trace;

import java.util.UUID;

/**
 * Created by caojiajun on 2024/11/27
 */
public class TraceIdUtils {

    public static String gen() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
