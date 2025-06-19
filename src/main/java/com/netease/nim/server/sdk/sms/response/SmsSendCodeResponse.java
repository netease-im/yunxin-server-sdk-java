package com.netease.nim.server.sdk.sms.response;

/**
 * Created by caojiajun on 2025/6/12
 */
public class SmsSendCodeResponse {
    private Long sendid;
    private String authCode;

    public Long getSendid() {
        return sendid;
    }

    public void setSendid(Long sendid) {
        this.sendid = sendid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
