package com.netease.nim.server.sdk.im.v2.conversation.request;

import java.util.List;

/**
 * Request object for batch getting conversation details
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversations/actions/conversation_ids
 */
public class BatchGetConversationsRequestV2 {
    
    /**
     * List of conversation IDs to retrieve
     * Format examples for each conversation ID:
     * - P2P chat: Accid1|1|Accid2
     * - Advanced group: Accid1|2|tid
     * - Super group: Accid1|3|tid
     * 
     * Maximum 100 conversation IDs can be specified in a single request.
     */
    private List<String> conversationIds;
    
    /**
     * Constructor with conversation IDs
     *
     * @param conversationIds list of conversation IDs to retrieve
     */
    public BatchGetConversationsRequestV2(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
    
    /**
     * Default constructor
     */
    public BatchGetConversationsRequestV2() {
    }
    
    /**
     * Get the conversation IDs
     *
     * @return list of conversation IDs
     */
    public List<String> getConversationIds() {
        return conversationIds;
    }
    
    /**
     * Set the conversation IDs
     *
     * @param conversationIds list of conversation IDs to set
     */
    public void setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
} 