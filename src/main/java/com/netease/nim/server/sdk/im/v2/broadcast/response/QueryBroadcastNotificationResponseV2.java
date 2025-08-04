package com.netease.nim.server.sdk.im.v2.broadcast.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class QueryBroadcastNotificationResponseV2 {

    @JSONField(name = "broadcast_id")
    private String broadcastId;

    @JSONField(name = "from_account_id")
    private String fromAccountId;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "offline_enabled")
    private Boolean offlineEnabled;

    @JSONField(name = "target_os")
    private List<String> targetOs;


    @JSONField(name = "create_time")
    private Long createTime;


    @JSONField(name = "expire_time")
    private Long expireTime;


    public String getBroadcastId() {
        return broadcastId;
    }


    public void setBroadcastId(String broadcastId) {
        this.broadcastId = broadcastId;
    }


    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getOfflineEnabled() {
        return offlineEnabled;
    }

    public void setOfflineEnabled(Boolean offlineEnabled) {
        this.offlineEnabled = offlineEnabled;
    }

    public List<String> getTargetOs() {
        return targetOs;
    }

    public void setTargetOs(List<String> targetOs) {
        this.targetOs = targetOs;
    }


    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
} 