package com.netease.nim.server.sdk.im.v1.signal.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 关闭信令频道请求
 */
public class CloseSignalRoomRequestV1 {

    @YunxinParam("channelId")
    private String channelId;

    @YunxinParam("from")
    private String from;

    @YunxinParam("isSave")
    private Integer isSave;

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

    public Integer getIsSave() {
        return isSave;
    }

    public void setIsSave(Integer isSave) {
        this.isSave = isSave;
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