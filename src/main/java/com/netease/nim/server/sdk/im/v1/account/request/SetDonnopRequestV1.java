package com.netease.nim.server.sdk.im.v1.account.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/26
 */
public class SetDonnopRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("donnopOpen")
    private Boolean donnopOpen;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Boolean getDonnopOpen() {
        return donnopOpen;
    }

    public void setDonnopOpen(Boolean donnopOpen) {
        this.donnopOpen = donnopOpen;
    }
}
