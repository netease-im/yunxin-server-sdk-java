package com.netease.nim.im.server.sdk.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request object for batch getting conversation groups
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/actions/group_ids
 */
public class BatchGetConversationGroupsRequestV2 {

    /**
     * Account ID that owns the conversation groups
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * List of group IDs to retrieve
     */
    @JSONField(name = "group_ids")
    private List<Long> groupIds;

    /**
     * Default constructor
     */
    public BatchGetConversationGroupsRequestV2() {
    }

    /**
     * Constructor with account ID and group IDs
     * 
     * @param accountId the account ID
     * @param groupIds the list of group IDs to retrieve
     */
    public BatchGetConversationGroupsRequestV2(String accountId, List<Long> groupIds) {
        this.accountId = accountId;
        this.groupIds = groupIds;
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

    /**
     * Get the list of group IDs
     * 
     * @return the list of group IDs
     */
    public List<Long> getGroupIds() {
        return groupIds;
    }

    /**
     * Set the list of group IDs
     * 
     * @param groupIds the list of group IDs to set
     */
    public void setGroupIds(List<Long> groupIds) {
        this.groupIds = groupIds;
    }
} 