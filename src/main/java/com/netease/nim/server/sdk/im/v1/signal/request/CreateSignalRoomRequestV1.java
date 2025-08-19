package com.netease.nim.server.sdk.im.v1.signal.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 创建信令频道请求
 */
public class CreateSignalRoomRequestV1 {

    @YunxinParam("channelName")
    private String channelName;

    @YunxinParam("type")
    private Integer type;

    @YunxinParam("from")
    private String from;

    @YunxinParam("ext")
    private String ext;

    @YunxinParam("isRoute")
    private Integer isRoute;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getIsRoute() {
        return isRoute;
    }

    public void setIsRoute(Integer isRoute) {
        this.isRoute = isRoute;
    }
} 