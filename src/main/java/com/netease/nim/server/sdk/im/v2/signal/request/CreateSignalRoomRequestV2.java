package com.netease.nim.server.sdk.im.v2.signal.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 创建信令房间请求 V2
 * 用于创建一个信令房间
 */
public class CreateSignalRoomRequestV2 {

    @JSONField(name = "channel_name")
    private String channelName;

    @JSONField(name = "creator_account_id")
    private String creatorAccountId;

    @JSONField(name = "channel_type")
    private Integer channelType;

    @JSONField(name = "channel_extension")
    private String channelExtension;

    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * 抄送配置
     */
    public static class RouteConfig {
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

        public Boolean getRouteEnabled() {
            return routeEnabled;
        }

        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getCreatorAccountId() {
        return creatorAccountId;
    }

    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getChannelExtension() {
        return channelExtension;
    }

    public void setChannelExtension(String channelExtension) {
        this.channelExtension = channelExtension;
    }

    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
} 