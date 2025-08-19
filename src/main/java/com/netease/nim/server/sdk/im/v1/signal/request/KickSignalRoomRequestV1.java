package com.netease.nim.server.sdk.im.v1.signal.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 将成员踢出信令频道请求
 * 用于将指定成员踢出信令频道房间，只有信令频道房间的创建者才能踢人
 */
public class KickSignalRoomRequestV1 {

    @YunxinParam("channelId")
    private String channelId;

    @YunxinParam("from")
    private String from;

    @YunxinParam("to")
    private String to;

    @YunxinParam("attachExt")
    private String attachExt;

    @YunxinParam("isSave")
    private Integer isSave;

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

    public Integer getIsSave() {
        return isSave;
    }

    public void setIsSave(Integer isSave) {
        this.isSave = isSave;
    }

    public Integer getIsRoute() {
        return isRoute;
    }

    public void setIsRoute(Integer isRoute) {
        this.isRoute = isRoute;
    }
} 