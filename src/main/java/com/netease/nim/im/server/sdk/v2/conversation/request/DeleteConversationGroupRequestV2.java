package com.netease.nim.im.server.sdk.v2.conversation.request;

/**
 * Request object for deleting a conversation group
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class DeleteConversationGroupRequestV2 {

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
    public DeleteConversationGroupRequestV2() {
    }

    /**
     * Constructor with required parameters
     *
     * @param groupId the group ID
     * @param accountId the account ID
     */
    public DeleteConversationGroupRequestV2(Long groupId, String accountId) {
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