package com.netease.nim.server.sdk.im.v2.signal.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 将成员踢出信令房间请求 V2
 * 将成员踢出信令房间
 */
public class KickSignalRoomMemberRequestV2 {

    /**
     * 信令房间id (必选)
     */
    @JSONField(name = "channel_id")
    private String channelId;

    /**
     * 操作者，必须是信令房间创建者 (必选)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;

    /**
     * 被踢的目标成员 (必选)
     */
    @JSONField(name = "target_account_id")
    private String targetAccountId;

    /**
     * 发送通知时的扩展字段，最长4096个字符 (可选)
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * 关闭通知是否存离线，默认false (可选)
     */
    @JSONField(name = "offline_enabled")
    private Boolean offlineEnabled;

    /**
     * 抄送配置 (可选)
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * 抄送配置类
     */
    public static class RouteConfig {
        /**
         * 是否抄送，默认false
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

        public Boolean getRouteEnabled() {
            return routeEnabled;
        }

        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
    }

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

    public String getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(String targetAccountId) {
        this.targetAccountId = targetAccountId;
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

    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
} 