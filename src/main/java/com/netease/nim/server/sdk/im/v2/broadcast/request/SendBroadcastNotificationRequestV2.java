package com.netease.nim.server.sdk.im.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;
import com.netease.nim.server.sdk.im.v2.message.request.SendTeamReadReceiptRequestV2;

import java.util.List;


public class SendBroadcastNotificationRequestV2 {

    @JSONField(name = "content")
    private String content;
    @JSONField(name = "from_account_id")
    private String fromAccountId;
    @JSONField(name = "offline_enabled")
    private Boolean offlineEnabled;
    @JSONField(name = "ttl")
    private Integer ttl;
    @JSONField(name = "target_os")
    private List<String> targetOs;
    public SendBroadcastNotificationRequestV2(){}
    public SendBroadcastNotificationRequestV2(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getFromAccountId() {
        return fromAccountId;
    }
    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    public Boolean getOfflineEnabled() {
        return offlineEnabled;
    }
    public void setOfflineEnabled(Boolean offlineEnabled) {
        this.offlineEnabled = offlineEnabled;
    }
    public Integer getTtl() {
        return ttl;
    }
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
    public List<String> getTargetOs() {
        return targetOs;
    }
    public void setTargetOs(List<String> targetOs) {
        this.targetOs = targetOs;
    }
} 