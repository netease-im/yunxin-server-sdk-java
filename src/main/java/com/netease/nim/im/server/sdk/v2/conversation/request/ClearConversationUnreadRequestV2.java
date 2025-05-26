package com.netease.nim.im.server.sdk.v2.conversation.request;

/**
 * Request object for clearing the unread count of a conversation
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/actions/clear_conversation_unread
 */
public class ClearConversationUnreadRequestV2 {

    /**
     * Conversation ID to clear unread count
     * Format examples:
     * - P2P chat: Accid1|1|Accid2
     * - Advanced group: Accid1|2|tid
     * - Super group: Accid1|3|tid
     */
    private String conversationId;

    /**
     * Default constructor
     */
    public ClearConversationUnreadRequestV2() {
    }
    
    /**
     * Constructor with conversation ID
     * 
     * @param conversationId the conversation ID to clear unread count for
     */
    public ClearConversationUnreadRequestV2(String conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * Get the conversation ID
     * 
     * @return the conversation ID
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Set the conversation ID
     * 
     * @param conversationId the conversation ID to set
     */
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
} 