package com.netease.nim.server.sdk.im.v2.friend.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for deleting a friend
 */
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

    /**
     * Set the account ID that initiates the friend deletion
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    /**
     * Set the account ID of the friend to be deleted
     * @param friendAccountId friend account ID
     */
    public void setFriendAccountId(String friendAccountId) {
        this.friendAccountId = friendAccountId;
    }

    public Boolean getDeleteAlias() {
        return deleteAlias;
    }

    /**
     * Set whether to delete friend's alias
     * @param deleteAlias true to delete alias, false to keep it (default is false)
     */
    public void setDeleteAlias(Boolean deleteAlias) {
        this.deleteAlias = deleteAlias;
    }
} 