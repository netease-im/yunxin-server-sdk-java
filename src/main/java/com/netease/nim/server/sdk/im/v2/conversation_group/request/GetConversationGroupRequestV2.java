package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request object for getting a conversation group
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class GetConversationGroupRequestV2 {

    /**
     * ID of the conversation group to retrieve
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * Account ID that owns the conversation group
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * Default constructor
     */
    public GetConversationGroupRequestV2() {
    }

    /**
     * Constructor with group ID and account ID
     * 
     * @param groupId the group ID to retrieve
     * @param accountId the account ID that owns the group
     */
    public GetConversationGroupRequestV2(Long groupId, String accountId) {
        this.groupId = groupId;
        this.accountId = accountId;
    }

    /**
     * Get the group ID
     * 
     * @return the group ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * Set the group ID
     * 
     * @param groupId the group ID to set
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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