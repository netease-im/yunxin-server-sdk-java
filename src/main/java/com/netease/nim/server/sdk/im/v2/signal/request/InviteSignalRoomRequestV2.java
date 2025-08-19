package com.netease.nim.server.sdk.im.v2.signal.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 邀请加入信令房间请求 V2
 * 邀请其他人加入信令房间
 */
public class InviteSignalRoomRequestV2 {

    /**
     * 信令房间id (必选)
     */
    @JSONField(name = "channel_id")
    private String channelId;

    /**
     * 操作者，必须是信令房间创建者或者房间里的人 (必选)
     */
    @JSONField(name = "inviter_account_id")
    private String inviterAccountId;

    /**
     * 被邀请者账号 (必选)
     */
    @JSONField(name = "invitee_account_id")
    private String inviteeAccountId;

    /**
     * 邀请ID，长度上限128字符 (必选)
     */
    @JSONField(name = "request_id")
    private String requestId;

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
     * 关闭通知是否存离线，默认false (可选)
     */
    @JSONField(name = "offline_enabled")
    private Boolean offlineEnabled;

    /**
     * 是否计入未读数，默认true (可选)
     */
    @JSONField(name = "unread_enabled")
    private Boolean unreadEnabled;

    /**
     * 推送配置 (可选)
     */
    @JSONField(name = "push_config")
    private PushConfig pushConfig;

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

    /**
     * 推送配置类
     */
    public static class PushConfig {
        /**
         * 是否推送，默认false
         */
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;

        /**
         * 推送标题，长度上限32字符
         */
        @JSONField(name = "push_title")
        private String pushTitle;

        /**
         * 推送文案，长度上限500字符
         */
        @JSONField(name = "push_content")
        private String pushContent;

        /**
         * 推送对应的 payload，必须是 JSON 格式，长度上限 4096 位字符
         */
        @JSONField(name = "push_payload")
        private String pushPayload;

        public Boolean getPushEnabled() {
            return pushEnabled;
        }

        public void setPushEnabled(Boolean pushEnabled) {
            this.pushEnabled = pushEnabled;
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
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getInviterAccountId() {
        return inviterAccountId;
    }

    public void setInviterAccountId(String inviterAccountId) {
        this.inviterAccountId = inviterAccountId;
    }

    public String getInviteeAccountId() {
        return inviteeAccountId;
    }

    public void setInviteeAccountId(String inviteeAccountId) {
        this.inviteeAccountId = inviteeAccountId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public Boolean getOfflineEnabled() {
        return offlineEnabled;
    }

    public void setOfflineEnabled(Boolean offlineEnabled) {
        this.offlineEnabled = offlineEnabled;
    }

    public Boolean getUnreadEnabled() {
        return unreadEnabled;
    }

    public void setUnreadEnabled(Boolean unreadEnabled) {
        this.unreadEnabled = unreadEnabled;
    }

    public PushConfig getPushConfig() {
        return pushConfig;
    }

    public void setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
    }
} 