package com.netease.nim.im.server.sdk.v2.conversation.request;

/**
 * Request object for listing all conversation groups
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups
 */
public class ListAllConversationGroupsRequestV2 {
    
    /**
     * Account ID (required, query parameter)
     */
    private String accountId;

    /**
     * Default constructor
     */
    public ListAllConversationGroupsRequestV2() {
    }

    /**
     * Constructor with required parameters
     *
     * @param accountId the account ID
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