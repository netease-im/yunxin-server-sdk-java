package com.netease.nim.server.sdk.im.v2.conversation_unread.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class OverViewsConversationResponseV2 {
    
    @JSONField(name = "account_id")
    private String accountId;

    
    @JSONField(name = "unread_count")
    private Integer unreadCount;

    
    public String getAccountId() {
        return accountId;
    }
    
    
    public Integer getUnreadCount() {
        return unreadCount;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    
    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }
}
