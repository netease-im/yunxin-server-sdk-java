package com.netease.nim.im.server.sdk.v1.friend.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class DeleteFriendRequestV1 {
    /**
     * 删除好友的发起者accid
     **/
    @YunxinParam("accid")
    private String accid;

    /**
     * 被删除的好友accid
     **/
    @YunxinParam("faccid")
    private String faccid;

    /**
     * 是否需要删除备注信息
     **/
    @YunxinParam("isDeleteAlias")
    private Boolean deleteAlias;

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

    public Boolean getDeleteAlias() {
        return deleteAlias;
    }

    public void setDeleteAlias(Boolean deleteAlias) {
        this.deleteAlias = deleteAlias;
    }
}
