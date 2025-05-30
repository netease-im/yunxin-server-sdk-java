package com.netease.nim.im.server.sdk.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request object for listing all conversation groups
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups
 */
public class ListAllConversationGroupsRequestV2 {

    /**
     * Account ID for which to list all conversation groups
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * Default constructor
     */
    public ListAllConversationGroupsRequestV2() {
    }

    /**
     * Constructor with account ID
     * 
     * @param accountId the account ID for which to list groups
     */
    public ListAllConversationGroupsRequestV2(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Get the account ID
     * 
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account ID
     * 
     * @param accountId the account ID to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 