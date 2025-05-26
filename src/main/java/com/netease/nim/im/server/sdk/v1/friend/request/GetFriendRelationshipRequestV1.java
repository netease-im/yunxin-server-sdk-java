package com.netease.nim.im.server.sdk.v1.friend.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class GetFriendRelationshipRequestV1 {
    /**
     * 查询好友关系的发起者accid
     **/
    @YunxinParam("accid")
    private String accid;

    /**
     * 被查询好友关系的用户accid
     **/
    @YunxinParam("faccid")
    private String faccid;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getFaccid() {
        return faccid;
    }

    public void setFaccid(String faccid) {
        this.faccid = faccid;
    }
}
