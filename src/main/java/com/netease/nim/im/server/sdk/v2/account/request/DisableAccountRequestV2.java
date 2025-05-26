package com.netease.nim.im.server.sdk.v2.account.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for disabling or enabling an account
 */
public class DisableAccountRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;

    @JSONField(name = "enabled")
    private Boolean enabled;

    @JSONField(name = "need_kick")
    private Boolean needKick;

    @JSONField(name = "kick_notify_extension")
    private String kickNotifyExtension;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getNeedKick() {
        return needKick;
    }

    public void setNeedKick(Boolean needKick) {
        this.needKick = needKick;
    }

    public String getKickNotifyExtension() {
        return kickNotifyExtension;
    }

    public void setKickNotifyExtension(String kickNotifyExtension) {
        this.kickNotifyExtension = kickNotifyExtension;
    }
} 