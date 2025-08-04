package com.netease.nim.server.sdk.im.v2.friend.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class HandleFriendAdditionRequestV2 {
    
    
    public static final Integer TYPE_ACCEPT = 3;
    
    
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
    
    
    private Integer type;

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

    public String getPostscript() {
        return postscript;
    }

    
    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public Integer getType() {
        return type;
    }

    
    public void setType(Integer type) {
        this.type = type;
    }
} 