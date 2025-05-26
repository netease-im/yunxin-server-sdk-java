package com.netease.nim.im.server.sdk.v2.conversation.request;

/**
 * Request object for getting a conversation group
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class GetConversationGroupRequestV2 {

    /**
     * Group ID (required, path parameter)
     */
    private Long groupId;
    
    /**
     * Account ID (required, query parameter)
     */
    private String accountId;

    /**
     * Default constructor
     */
    public GetConversationGroupRequestV2() {
    }

    /**
     * Constructor with required parameters
     *
     * @param groupId the group ID
     * @param accountId the account ID
     */
    public GetConversationGroupRequestV2(Long groupId, String accountId) {
        this.groupId = groupId;
        this.accountId = accountId;
    }

    // Getters and Setters

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 