package com.netease.nim.im.server.sdk.v2.friend.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response class for handling friend addition requests
 */
public class HandleFriendAdditionResponseV2 {

    @JSONField(name = "friend_account_id")
    private String friendAccountId;
    
    @JSONField(name = "alias")
    private String alias;
    
    @JSONField(name = "extension")
    private String extension;
    
    @JSONField(name = "customer_extension")
    private String customerExtension;

    public String getFriendAccountId() {
        return friendAccountId;
    }

    public void setFriendAccountId(String friendAccountId) {
        this.friendAccountId = friendAccountId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCustomerExtension() {
        return customerExtension;
    }

    public void setCustomerExtension(String customerExtension) {
        this.customerExtension = customerExtension;
    }
} 