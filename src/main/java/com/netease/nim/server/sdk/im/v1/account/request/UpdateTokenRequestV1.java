package com.netease.nim.server.sdk.im.v1.account.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/26
 */
public class UpdateTokenRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("token")
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
