package com.netease.nim.server.sdk.im.v1.account.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/26
 */
public class RefreshTokenRequestV1 {

    @YunxinParam("accid")
    private String accid;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }
}
