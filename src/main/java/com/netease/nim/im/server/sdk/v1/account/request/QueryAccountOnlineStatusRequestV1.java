package com.netease.nim.im.server.sdk.v1.account.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Created by caojiajun on 2024/12/26
 */
public class QueryAccountOnlineStatusRequestV1 {

    @YunxinParam("accids")
    private List<String> accids;

    public List<String> getAccids() {
        return accids;
    }

    public void setAccids(List<String> accids) {
        this.accids = accids;
    }
}
