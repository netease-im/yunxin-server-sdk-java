package com.netease.nim.server.sdk.sms.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2025/6/12
 */
public class SmsSendCodeRequest {

    @YunxinParam("mobile")
    private String mobile;

    @YunxinParam("templateid")
    private Integer templateid;

    @YunxinParam("codeLen")
    private Integer codeLen;

    @YunxinParam("authCode")
    private String authCode;

    @YunxinParam("needUp")
    private Boolean needUp;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public Integer getCodeLen() {
        return codeLen;
    }

    public void setCodeLen(Integer codeLen) {
        this.codeLen = codeLen;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Boolean getNeedUp() {
        return needUp;
    }

    public void setNeedUp(Boolean needUp) {
        this.needUp = needUp;
    }
}
