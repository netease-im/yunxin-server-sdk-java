package com.netease.nim.server.sdk.im.v1.account.request;


import java.util.List;

/**
 * Created by caojiajun on 2025/3/26
 */
public class QueryUserInfosRequestV1 {

    private List<String> accids;

    private Boolean muteStatus;

    public List<String> getAccids() {
        return accids;
    }

    public void setAccids(List<String> accids) {
        this.accids = accids;
    }

    public Boolean getMuteStatus() {
        return muteStatus;
    }

    public void setMuteStatus(Boolean muteStatus) {
        this.muteStatus = muteStatus;
    }
}
