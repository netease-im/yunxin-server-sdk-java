package com.netease.nim.server.sdk.im.v2.friend.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for updating friend information
 */
public class UpdateFriendRequestV2 {

    @JSONField(name = "account_id")
    private String accountId;
    
    @JSONField(name = "friend_account_id")
    private String friendAccountId;
    
    @JSONField(name = "alias")
    private String alias;
    
    @JSONField(name = "extension")
    private String extension;
    
    @JSONField(name = "customer_extension")
    private String customerExtension;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that initiates the update
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    /**
     * Set the account ID of the friend to update
     * @param friendAccountId friend account ID
     */
    public void setFriendAccountId(String friendAccountId) {
        this.friendAccountId = friendAccountId;
    }

    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias for the friend, max 128 characters
     * @param alias friend alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getExtension() {
        return extension;
    }

    /**
     * Set the extension field, max 256 characters
     * The extension field can be read and written by both client and server
     * @param extension extension field
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCustomerExtension() {
        return customerExtension;
    }

    /**
     * Set the customer extension field
     * This field can only be set by server API and is only passed through by SDK
     * @param customerExtension customer extension field
     */
    public void setCustomerExtension(String customerExtension) {
        this.customerExtension = customerExtension;
    }
}