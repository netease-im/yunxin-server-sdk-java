package com.netease.nim.im.server.sdk.v2.conversation.request;

/**
 * Request object for retrieving conversation overview for an account
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_overviews/{account_id}
 */
public class OverViewsConversationRequestV2 {

    /**
     * Account ID for which to retrieve the conversation overview
     */
    private String accountId;

    /**
     * Default constructor
     */
    public OverViewsConversationRequestV2() {
    }
    
    /**
     * Constructor with account ID
     * 
     * @param accountId the account ID for which to retrieve the overview
     */
    public OverViewsConversationRequestV2(String accountId) {
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