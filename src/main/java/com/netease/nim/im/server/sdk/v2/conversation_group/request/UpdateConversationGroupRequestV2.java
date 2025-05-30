package com.netease.nim.im.server.sdk.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request object for updating a conversation group
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class UpdateConversationGroupRequestV2 {

    /**
     * ID of the conversation group to update
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * Account ID that owns the conversation group
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * New name for the conversation group (optional)
     */
    @JSONField(name = "name")
    private String name;

    /**
     * Custom server extension data (optional)
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * Conversations to add or remove from the group (optional)
     */
    @JSONField(name = "conversations")
    private Conversations conversations;

    /**
     * Class representing conversations to add or remove
     */
    public static class Conversations {
        /**
         * Operation type
         * 1: Add conversations to the group
         * 2: Remove conversations from the group
         */
        @JSONField(name = "type")
        private Integer type;

        /**
         * List of conversation IDs to add or remove
         */
        @JSONField(name = "conversation_ids")
        private List<String> conversationIds;

        /**
         * Get the operation type
         * 
         * @return the operation type
         */
        public Integer getType() {
            return type;
        }

        /**
         * Set the operation type
         * 
         * @param type the operation type to set
         */
        public void setType(Integer type) {
            this.type = type;
        }

        /**
         * Get the conversation IDs
         * 
         * @return the conversation IDs
         */
        public List<String> getConversationIds() {
            return conversationIds;
        }

        /**
         * Set the conversation IDs
         * 
         * @param conversationIds the conversation IDs to set
         */
        public void setConversationIds(List<String> conversationIds) {
            this.conversationIds = conversationIds;
        }
    }

    /**
     * Default constructor
     */
    public UpdateConversationGroupRequestV2() {
    }

    /**
     * Constructor with required fields
     * 
     * @param groupId the group ID to update
     * @param accountId the account ID that owns the group
     */
    public UpdateConversationGroupRequestV2(Long groupId, String accountId) {
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
     * Get the conversations
     * 
     * @return the conversations
     */
    public Conversations getConversations() {
        return conversations;
    }

    /**
     * Set the conversations
     * 
     * @param conversations the conversations to set
     */
    public void setConversations(Conversations conversations) {
        this.conversations = conversations;
    }
} 