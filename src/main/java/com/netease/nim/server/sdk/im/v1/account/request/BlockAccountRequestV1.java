package com.netease.nim.server.sdk.im.v1.account.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by caojiajun on 2024/12/26
 */
public class BlockAccountRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("needkick")
    private Boolean needKick;

    @YunxinParam("kickNotifyExt")
    private String kickNotifyExt;

    @YunxinParam("needUnbindPushToken")
    private Boolean needUnbindPushToken;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Boolean getNeedKick() {
        return needKick;
    }

    public void setNeedKick(Boolean needKick) {
        this.needKick = needKick;
    }

    public String getKickNotifyExt() {
        return kickNotifyExt;
    }

    public void setKickNotifyExt(String kickNotifyExt) {
        this.kickNotifyExt = kickNotifyExt;
    }

    public Boolean getNeedUnbindPushToken() {
        return needUnbindPushToken;
    }

    public void setNeedUnbindPushToken(Boolean needUnbindPushToken) {
        this.needUnbindPushToken = needUnbindPushToken;
    }
}
