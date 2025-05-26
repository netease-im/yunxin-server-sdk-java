package com.netease.nim.im.server.sdk.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for updating a conversation
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
 */
public class UpdateConversationRequestV2 {

    /**
     * Conversation ID (required, but not serialized to JSON as it is used in the URL path)
     * Format examples:
     * - P2P chat: account1|1|account2
     * - Advanced team: account1|2|team_id
     * - Super team: account1|3|team_id
     */
    @JSONField(name = "conversation_id")
    private String conversationId;

    /**
     * Server extension field (optional)
     * Maximum length: 1024 characters
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

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
     * @return this instance for chaining
     */
    public UpdateConversationRequestV2 setConversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }

    /**
     * Gets the server extension field
     * 
     * @return server extension
     */
    public String getServerExtension() {
        return serverExtension;
    }

    /**
     * Sets the server extension field
     * 
     * @param serverExtension server extension to set
     * @return this instance for chaining
     */
    public UpdateConversationRequestV2 setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
        return this;
    }
}