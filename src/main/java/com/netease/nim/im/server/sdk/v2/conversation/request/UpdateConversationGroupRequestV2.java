package com.netease.nim.im.server.sdk.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request object for updating a conversation group
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class UpdateConversationGroupRequestV2 {

    /**
     * Group ID (required, path parameter)
     * Not included in the JSON body
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * Account ID (required)
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * Updated conversation group name (optional)
     */
    @JSONField(name = "name")
    private String name;

    /**
     * Updated server extension information (optional)
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * Conversations operations (optional)
     */
    @JSONField(name = "conversations")
    private Conversations conversations;

    /**
     * Inner class for conversation operations
     */
    public static class Conversations {
        /**
         * Operation type (required)
         * 1: Add conversations to group
         * 2: Remove conversations from group
         */
        @JSONField(name = "type")
        private Integer type;

        /**
         * List of conversation IDs (required)
         * Maximum 100 conversation IDs
         */
        @JSONField(name = "conversation_ids")
        private List<String> conversationIds;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public List<String> getConversationIds() {
            return conversationIds;
        }

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
     * Constructor with required parameters
     *
     * @param groupId the group ID
     * @param accountId the account ID
     */
    public UpdateConversationGroupRequestV2(Long groupId, String accountId) {
        this.groupId = groupId;
        this.accountId = accountId;
    }

    /**
     * Helper method to create a request for adding conversations to a group
     *
     * @param groupId the group ID
     * @param accountId the account ID
     * @param conversationIds the list of conversation IDs to add
     * @return a request configured for adding conversations
     */
    public static UpdateConversationGroupRequestV2 createAddConversationsRequest(
            Long groupId, String accountId, List<String> conversationIds) {
        UpdateConversationGroupRequestV2 request = new UpdateConversationGroupRequestV2(groupId, accountId);
        
        Conversations conversations = new Conversations();
        conversations.setType(1); // Add conversations
        conversations.setConversationIds(conversationIds);
        
        request.setConversations(conversations);
        return request;
    }
    
    /**
     * Helper method to create a request for removing conversations from a group
     *
     * @param groupId the group ID
     * @param accountId the account ID
     * @param conversationIds the list of conversation IDs to remove
     * @return a request configured for removing conversations
     */
    public static UpdateConversationGroupRequestV2 createRemoveConversationsRequest(
            Long groupId, String accountId, List<String> conversationIds) {
        UpdateConversationGroupRequestV2 request = new UpdateConversationGroupRequestV2(groupId, accountId);
        
        Conversations conversations = new Conversations();
        conversations.setType(2); // Remove conversations
        conversations.setConversationIds(conversationIds);
        
        request.setConversations(conversations);
        return request;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServerExtension() {
        return serverExtension;
    }

    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }

    public Conversations getConversations() {
        return conversations;
    }

    public void setConversations(Conversations conversations) {
        this.conversations = conversations;
    }
} 