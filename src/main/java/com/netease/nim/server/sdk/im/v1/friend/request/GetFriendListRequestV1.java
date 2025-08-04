package com.netease.nim.server.sdk.im.v1.friend.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class GetFriendListRequestV1 {

    @YunxinParam("accid")
    private String accid;

    @YunxinParam("updatetime")
    private Long updatetime;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }
}
