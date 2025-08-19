package com.netease.nim.server.sdk.im.v2.signal.request;

/**
 * 关闭信令房间请求 V2
 * 用于关闭一个信令房间
 */
public class CloseSignalRoomRequestV2 {

    /**
     * 信令房间id (必选)
     */
    private String channelId;

    /**
     * 操作者，必须是信令房间创建者或者房间里的人 (必选)
     */
    private String operatorAccountId;

    /**
     * 关闭通知的扩展字段，最长4096个字符 (可选)
     */
    private String serverExtension;

    /**
     * 关闭通知是否存离线，默认false (可选)
     */
    private Boolean offlineEnabled;

    /**
     * 是否抄送，默认false (可选)
     */
    private Boolean routeEnabled;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getOperatorAccountId() {
        return operatorAccountId;
    }

    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }

    public String getServerExtension() {
        return serverExtension;
    }

    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }

    public Boolean getOfflineEnabled() {
        return offlineEnabled;
    }

    public void setOfflineEnabled(Boolean offlineEnabled) {
        this.offlineEnabled = offlineEnabled;
    }

    public Boolean getRouteEnabled() {
        return routeEnabled;
    }

    public void setRouteEnabled(Boolean routeEnabled) {
        this.routeEnabled = routeEnabled;
    }
} 