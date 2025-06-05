package com.netease.nim.server.sdk.core;


/**
 * Created by caojiajun on 2025/6/4
 */
public enum BizName {
    IM(1),
    RTC(2),
    MEETING(3),
    NEROOM(4),
    SMS(5),
    ;
    private final int value;

    BizName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
