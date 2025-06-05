package com.netease.nim.server.sdk.im.v1.friend.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class GetFriendListRequestV1 {
    /**
     * 查询好友列表的发起者accid
     **/
    @YunxinParam("accid")
    private String accid;

    /**
     * 更新时间戳
     **/
    @YunxinParam("updatetime")
    private long updatetime;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }
}
