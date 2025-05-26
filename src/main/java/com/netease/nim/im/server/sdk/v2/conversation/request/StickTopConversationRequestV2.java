package com.netease.nim.im.server.sdk.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request object for sticking top (pinning) a conversation
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/actions/stick_top_conversation
 */
public class StickTopConversationRequestV2 {
    
    /**
     * Conversation ID to pin/unpin
     * Format examples:
     * - P2P chat: Accid1|1|Accid2
     * - Advanced group: Accid1|2|tid
     * - Super group: Accid1|3|tid
     */
    @JSONField(name = "conversation_id")
    private String conversationId;
    
    /**
     * Whether to pin the conversation or unpin it
     * 1: Pin the conversation
     * 0: Unpin the conversation
     */
    @JSONField(name = "top_type")
    private Integer topType;
    
    /**
     * Constructor with all parameters
     * 
     * @param conversationId Conversation ID to pin/unpin
     * @param topType 1 to pin, 0 to unpin
     */
    public StickTopConversationRequestV2(String conversationId, Integer topType) {
        this.conversationId = conversationId;
        this.topType = topType;
    }
    
    /**
     * Constructor for pinning a conversation
     * 
     * @param conversationId Conversation ID to pin
     */
    public static StickTopConversationRequestV2 createPinRequest(String conversationId) {
        return new StickTopConversationRequestV2(conversationId, 1);
    }
    
    /**
     * Constructor for unpinning a conversation
     * 
     * @param conversationId Conversation ID to unpin
     */
    public static StickTopConversationRequestV2 createUnpinRequest(String conversationId) {
        return new StickTopConversationRequestV2(conversationId, 0);
    }
    
    /**
     * Default constructor
     */
    public StickTopConversationRequestV2() {
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
    
    /**
     * Get the top type
     * 
     * @return 1 for pin, 0 for unpin
     */
    public Integer getTopType() {
        return topType;
    }
    
    /**
     * Set the top type
     * 
     * @param topType 1 for pin, 0 for unpin
     */
    public void setTopType(Integer topType) {
        this.topType = topType;
    }
} 