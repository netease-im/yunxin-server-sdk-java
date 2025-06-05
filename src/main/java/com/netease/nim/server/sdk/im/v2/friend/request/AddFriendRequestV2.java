package com.netease.nim.server.sdk.im.v2.friend.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for adding a friend
 */
public class AddFriendRequestV2 {

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
    
    @JSONField(name = "postscript")
    private String postscript;
    
    @JSONField(name = "type")
    private Integer type;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that initiates the friend request
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    /**
     * Set the account ID to be added as a friend
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

    public String getPostscript() {
        return postscript;
    }

    /**
     * Set the postscript for friend verification (when type=2)
     * This field needs to pass anti-spam review
     * @param postscript postscript message
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public Integer getType() {
        return type;
    }

    /**
     * Set the friend verification type
     * @param type 1: add directly without verification (default), 2: requires verification
     */
    public void setType(Integer type) {
        this.type = type;
    }
} 