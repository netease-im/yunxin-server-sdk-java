package com.netease.nim.im.server.sdk.v2.friend.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request class for handling (accepting/rejecting) friend addition requests
 */
public class HandleFriendAdditionRequestV2 {
    
    /**
     * Accept friend request
     */
    public static final Integer TYPE_ACCEPT = 3;
    
    /**
     * Reject friend request
     */
    public static final Integer TYPE_REJECT = 4;

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
    
    /**
     * Type is not included in the JSON as it's a query parameter
     */
    private Integer type;

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID that is handling the friend request
     * @param accountId account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFriendAccountId() {
        return friendAccountId;
    }

    /**
     * Set the account ID of the friend to be accepted or rejected
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
     * Set the postscript message for the response
     * @param postscript postscript message
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public Integer getType() {
        return type;
    }

    /**
     * Set the type of handling action
     * @param type 3: accept (default), 4: reject
     */
    public void setType(Integer type) {
        this.type = type;
    }
} 