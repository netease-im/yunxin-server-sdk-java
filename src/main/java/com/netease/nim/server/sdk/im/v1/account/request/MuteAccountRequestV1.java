package com.netease.nim.server.sdk.im.v1.account.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/26
 */
public class MuteAccountRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("mute")
    private Boolean mute;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Boolean getMute() {
        return mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
    }
}
