package com.netease.nim.im.server.sdk.v2.message.request;

/**
 * Request object for deleting all messages in a conversation
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
 * 
 * This API allows for deleting all messages in a conversation with different options:
 * - type=1: Delete all roaming messages
 * - type=2: Delete all history messages
 * - type=3: Delete both roaming and history messages
 */
public class DeleteConversationMessagesRequestV2 {
    
    private String conversationId;
    private Integer type;
    
    /**
     * Default constructor
     */
    public DeleteConversationMessagesRequestV2() {
    }
    
    /**
     * Constructor with conversation ID and type
     * 
     * @param conversationId the conversation ID
     * @param type the deletion type:
     *             1 - Delete all roaming messages
     *             2 - Delete all history messages
     *             3 - Delete both roaming and history messages
     */
    public DeleteConversationMessagesRequestV2(String conversationId, Integer type) {
        this.conversationId = conversationId;
        this.type = type;
    }
    
    // Getters and setters
    
    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
} 