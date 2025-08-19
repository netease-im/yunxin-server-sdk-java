package com.netease.nim.server.sdk.im.v1.signal.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * 邀请加入信令频道请求
 * 用于邀请成员加入信令频道房间
 */
public class InviteSignalRoomRequestV1 {

    @YunxinParam("channelId")
    private String channelId;

    @YunxinParam("from")
    private String from;

    @YunxinParam("to")
    private String to;

    @YunxinParam("requestId")
    private String requestId;

    @YunxinParam("attachExt")
    private String attachExt;

    @YunxinParam("needPush")
    private Integer needPush;

    @YunxinParam("pushTitle")
    private String pushTitle;

    @YunxinParam("pushContent")
    private String pushContent;

    @YunxinParam("pushPayload")
    private String pushPayload;

    @YunxinParam("needBadge")
    private Integer needBadge;

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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAttachExt() {
        return attachExt;
    }

    public void setAttachExt(String attachExt) {
        this.attachExt = attachExt;
    }

    public Integer getNeedPush() {
        return needPush;
    }

    public void setNeedPush(Integer needPush) {
        this.needPush = needPush;
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getPushPayload() {
        return pushPayload;
    }

    public void setPushPayload(String pushPayload) {
        this.pushPayload = pushPayload;
    }

    public Integer getNeedBadge() {
        return needBadge;
    }

    public void setNeedBadge(Integer needBadge) {
        this.needBadge = needBadge;
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