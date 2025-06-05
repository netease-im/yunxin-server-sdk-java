package com.netease.nim.server.sdk.im.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for creating a conversation
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations
 */
public class CreateConversationRequestV2 {
    
    /**
     * Conversation ID (required)
     * 
     * Format: sender_id|conversation_type|receiver_id or sender_id|conversation_type|team_id
     * - sender_id: The account ID of the conversation initiator
     * - conversation_type: 1 for P2P chat, 2 for advanced team chat, 3 for super team chat
     * - receiver_id: The account ID of the conversation receiver (for P2P chat)
     * - team_id: The team ID (for team chat)
     * 
     * Examples:
     * - P2P chat: account1|1|account2
     * - Advanced team: account1|2|team_id
     * - Super team: account1|3|team_id
     */
    @JSONField(name = "conversation_id")
    private String conversationId;
    
    /**
     * Get the conversation ID
     * @return the conversation ID
     */
    public String getConversationId() {
        return conversationId;
    }
    
    /**
     * Set the conversation ID (required)
     * @param conversationId the conversation ID to set
     */
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    
    /**
     * Helper method to create a P2P conversation ID
     * @param senderId the sender account ID
     * @param receiverId the receiver account ID
     * @return the conversation ID
     */
    public static String createP2PConversationId(String senderId, String receiverId) {
        return senderId + "|1|" + receiverId;
    }
    
    /**
     * Helper method to create an advanced team conversation ID
     * @param senderId the sender account ID
     * @param teamId the team ID
     * @return the conversation ID
     */
    public static String createAdvancedTeamConversationId(String senderId, String teamId) {
        return senderId + "|2|" + teamId;
    }
    
    /**
     * Helper method to create a super team conversation ID
     * @param senderId the sender account ID
     * @param teamId the team ID
     * @return the conversation ID
     */
    public static String createSuperTeamConversationId(String senderId, String teamId) {
        return senderId + "|3|" + teamId;
    }
} 