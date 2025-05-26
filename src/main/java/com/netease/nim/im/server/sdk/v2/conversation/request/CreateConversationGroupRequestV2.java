package com.netease.nim.im.server.sdk.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request object for creating a conversation group
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversation_groups
 */
public class CreateConversationGroupRequestV2 {

    /**
     * Account ID (required)
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * Conversation group name (required)
     */
    @JSONField(name = "name")
    private String name;

    /**
     * Server extension information (optional)
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * List of conversation IDs to add to the group (optional)
     * Maximum 100 conversation IDs
     */
    @JSONField(name = "conversation_ids")
    private List<String> conversationIds;

    /**
     * Default constructor
     */
    public CreateConversationGroupRequestV2() {
    }

    /**
     * Constructor with required parameters
     *
     * @param accountId the account ID
     * @param name the conversation group name
     */
    public CreateConversationGroupRequestV2(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    /**
     * Full constructor
     *
     * @param accountId the account ID
     * @param name the conversation group name
     * @param serverExtension the server extension information
     * @param conversationIds the list of conversation IDs
     */
    public CreateConversationGroupRequestV2(String accountId, String name, String serverExtension, List<String> conversationIds) {
        this.accountId = accountId;
        this.name = name;
        this.serverExtension = serverExtension;
        this.conversationIds = conversationIds;
    }

    // Getters and Setters

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

    public List<String> getConversationIds() {
        return conversationIds;
    }

    public void setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
} 