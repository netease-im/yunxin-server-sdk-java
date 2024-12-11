package com.netease.nim.im.server.sdk.core.http;

/**
 * Created by caojiajun on 2024/11/27
 */
public enum ContextType {

    form_url_encoded("application/x-www-form-urlencoded;charset=UTF-8"),
    json("application/json;charset=UTF-8"),
    ;

    private final String value;

    ContextType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
