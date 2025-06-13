package com.netease.nim.server.sdk.sms.response;

/**
 * Created by caojiajun on 2025/6/12
 */
public class SmsSendCodeResponse {
    private long sendid;
    private String authCode;

    public long getSendid() {
        return sendid;
    }

    public void setSendid(long sendid) {
        this.sendid = sendid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
