package com.netease.nim.server.sdk.im.v2.account.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for setting account push configuration
 */
public class SetPushConfigRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;

    @JSONField(name = "push_enabled_when_desktop_online")
    private Boolean pushEnabledWhenDesktopOnline;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Boolean getPushEnabledWhenDesktopOnline() {
        return pushEnabledWhenDesktopOnline;
    }

    public void setPushEnabledWhenDesktopOnline(Boolean pushEnabledWhenDesktopOnline) {
        this.pushEnabledWhenDesktopOnline = pushEnabledWhenDesktopOnline;
    }
} 