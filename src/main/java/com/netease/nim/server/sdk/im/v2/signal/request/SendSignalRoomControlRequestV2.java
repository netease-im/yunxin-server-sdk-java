package com.netease.nim.server.sdk.im.v2.signal.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 信令房间发送控制指令请求 V2
 * 可以发给房间里的某个成员，也可以广播给房间里所有成员
 */
public class SendSignalRoomControlRequestV2 {

    /**
     * 信令房间id (必选)
     */
    @JSONField(name = "channel_id")
    private String channelId;

    /**
     * 操作者，必须是信令房间创建者或者房间里的人 (必选)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;

    /**
     * 控制指令的目标成员，如果缺失，则表示发送给房间里所有人 (可选)
     */
    @JSONField(name = "target_account_id")
    private String targetAccountId;

    /**
     * 发送通知时的扩展字段，最长4096个字符 (可选)
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

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

    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
} 