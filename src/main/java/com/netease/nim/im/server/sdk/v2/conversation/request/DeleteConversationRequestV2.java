package com.netease.nim.im.server.sdk.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for deleting a conversation
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
 */
public class DeleteConversationRequestV2 {

    /**
     * Conversation ID (required, used in the URL path)
     * Format examples:
     * - P2P chat: account1|1|account2
     * - Advanced team: account1|2|team_id
     * - Super team: account1|3|team_id
     */
    @JSONField(name = "conversation_id")
    private String conversationId;

    /**
     * Whether to delete the conversation's corresponding history messages
     * - true: Delete history messages along with the conversation
     * - false: Only delete the conversation, keep history messages
     */
    private Boolean clearMessage;

    /**
     * Get the conversation ID
     * 
     * @return conversation ID
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Set the conversation ID (required for URL path)
     * 
     * @param conversationId conversation ID to set
     */
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * Get whether to clear message history
     * 
     * @return true to delete message history, false to keep it
     */
    public Boolean getClearMessage() {
        return clearMessage;
    }

    /**
     * Set whether to clear message history
     * 
     * @param clearMessage true to delete message history, false to keep it
     */
    public void setClearMessage(Boolean clearMessage) {
        this.clearMessage = clearMessage;
    }
} 