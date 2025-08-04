package com.netease.nim.server.sdk.im.v2.friend.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class DeleteFriendRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;
    
    @JSONField(name = "friend_account_id")
    private String friendAccountId;
    
    @JSONField(name = "delete_alias")
    private Boolean deleteAlias;

    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    
    public void setFriendAccountId(String friendAccountId) {
        this.friendAccountId = friendAccountId;
    }

    public Boolean getDeleteAlias() {
        return deleteAlias;
    }

    
    public void setDeleteAlias(Boolean deleteAlias) {
        this.deleteAlias = deleteAlias;
    }
} 