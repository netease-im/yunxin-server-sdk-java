package com.netease.nim.server.sdk.im.v2.conversation_unread.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response object for retrieving conversation overview for an account
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_overviews/{account_id}
 */
public class OverViewsConversationResponseV2 {
    /**
     * Account ID for which the overview is returned
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * Total unread count across all conversations for this account
     */
    @JSONField(name = "unread_count")
    private Integer unreadCount;

    /**
     * Get the account ID
     * 
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Get the total unread count across all conversations
     * 
     * @return the unread count
     */
    public Integer getUnreadCount() {
        return unreadCount;
    }
    
    /**
     * Set the account ID
     * 
     * @param accountId the account ID to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Set the unread count
     * 
     * @param unreadCount the unread count to set
     */
    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }
}
