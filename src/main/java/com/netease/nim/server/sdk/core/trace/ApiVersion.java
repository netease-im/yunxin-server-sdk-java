package com.netease.nim.server.sdk.core.trace;

/**
 * Created by caojiajun on 2024/12/9
 */
public enum ApiVersion {
    V1(1),
    V2(2),
    ;
    private final int value;

    ApiVersion(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
