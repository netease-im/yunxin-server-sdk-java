package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request object for creating a conversation group
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversation_groups
 */
public class CreateConversationGroupRequestV2 {

    /**
     * Account ID that will own the conversation group
     */
    @JSONField(name = "account_id")
    private String accountId;

    /**
     * Name of the conversation group to create
     */
    @JSONField(name = "name")
    private String name;

    /**
     * Optional server extension data
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * Optional list of conversation IDs to add to the group
     */
    @JSONField(name = "conversation_ids")
    private List<String> conversationIds;

    /**
     * Default constructor
     */
    public CreateConversationGroupRequestV2() {
    }

    /**
     * Constructor with required fields
     * 
     * @param accountId the account ID that will own the group
     * @param name the name of the group
     */
    public CreateConversationGroupRequestV2(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    /**
     * Constructor with all fields
     * 
     * @param accountId the account ID that will own the group
     * @param name the name of the group
     * @param serverExtension optional server extension data
     * @param conversationIds optional list of conversation IDs to add
     */
    public CreateConversationGroupRequestV2(String accountId, String name, String serverExtension, List<String> conversationIds) {
        this.accountId = accountId;
        this.name = name;
        this.serverExtension = serverExtension;
        this.conversationIds = conversationIds;
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