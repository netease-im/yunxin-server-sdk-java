package com.netease.nim.server.sdk.im.v2.conversation.request;

/**
 * Request object for getting conversation details
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversations/{conversation_id}
 */
public class GetConversationRequestV2 {
    
    /**
     * ID of the conversation to retrieve
     * Format examples:
     * - P2P chat: Accid1|1|Accid2
     * - Advanced group: Accid1|2|tid
     * - Super group: Accid1|3|tid
     */
    private String conversationId;
    
    /**
     * Constructor with conversation ID
     *
     * @param conversationId ID of the conversation to retrieve
     */
    public GetConversationRequestV2(String conversationId) {
        this.conversationId = conversationId;
    }
    
    /**
     * Default constructor
     */
    public GetConversationRequestV2() {
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