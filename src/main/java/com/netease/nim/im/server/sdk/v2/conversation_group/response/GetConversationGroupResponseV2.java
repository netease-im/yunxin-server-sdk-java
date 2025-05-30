package com.netease.nim.im.server.sdk.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response object for getting a conversation group
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class GetConversationGroupResponseV2 {

    /**
     * ID of the conversation group
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * Name of the conversation group
     */
    @JSONField(name = "name")
    private String name;

    /**
     * Custom server extension data
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * Account ID that owns the group
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * List of conversation IDs in the group
     */
    @JSONField(name = "conversation_ids")
    private List<String> conversationIds;

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
     * Get the name
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the server extension data
     * 
     * @return the server extension data
     */
    public String getServerExtension() {
        return serverExtension;
    }

    /**
     * Set the server extension data
     * 
     * @param serverExtension the server extension data to set
     */
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
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
     * Get the conversation IDs
     * 
     * @return the list of conversation IDs
     */
    public List<String> getConversationIds() {
        return conversationIds;
    }

    /**
     * Set the conversation IDs
     * 
     * @param conversationIds the list of conversation IDs to set
     */
    public void setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
} 