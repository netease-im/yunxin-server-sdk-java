package com.netease.nim.server.sdk.im.v1.signal.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 发送控制指令请求
 * 用于在信令频道房间中发送自定义控制指令
 */
public class CtrlSignalRoomRequestV1 {

    @YunxinParam("channelId")
    private String channelId;

    @YunxinParam("from")
    private String from;

    @YunxinParam("to")
    private String to;

    @YunxinParam("attachExt")
    private String attachExt;

    @YunxinParam("isRoute")
    private Integer isRoute;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAttachExt() {
        return attachExt;
    }

    public void setAttachExt(String attachExt) {
        this.attachExt = attachExt;
    }

    public Integer getIsRoute() {
        return isRoute;
    }

    public void setIsRoute(Integer isRoute) {
        this.isRoute = isRoute;
    }
} 