package com.netease.nim.server.sdk.live.manage.request;

/**
 * Created by caojiajun on 2025/6/12
 */
public class LiveCreateChannelRequest {
    private String name;
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
