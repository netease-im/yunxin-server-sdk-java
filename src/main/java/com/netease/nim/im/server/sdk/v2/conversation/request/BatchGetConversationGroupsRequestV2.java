package com.netease.nim.im.server.sdk.v2.conversation.request;

import java.util.List;

/**
 * Request object for batch getting conversation groups
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/actions/group_ids
 */
public class BatchGetConversationGroupsRequestV2 {

    /**
     * Account ID (required, query parameter)
     */
    private String accountId;
    
    /**
     * Group IDs (required, query parameter)
     * List of conversation group IDs to retrieve
     */
    private List<Long> groupIds;

    /**
     * Default constructor
     */
    public BatchGetConversationGroupsRequestV2() {
    }

    /**
     * Constructor with required parameters
     *
     * @param accountId the account ID
     * @param groupIds the list of group IDs
     */
    public BatchGetConversationGroupsRequestV2(String accountId, List<Long> groupIds) {
        this.accountId = accountId;
        this.groupIds = groupIds;
    }

    // Getters and Setters

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<Long> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Long> groupIds) {
        this.groupIds = groupIds;
    }
} 