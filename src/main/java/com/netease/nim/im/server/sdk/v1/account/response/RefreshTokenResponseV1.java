package com.netease.nim.im.server.sdk.v1.account.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by caojiajun on 2024/12/26
 */
public class RefreshTokenResponseV1 {

    @JSONField(name = "accid")
    private String accid;

    @JSONField(name = "token")
    private String token;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
