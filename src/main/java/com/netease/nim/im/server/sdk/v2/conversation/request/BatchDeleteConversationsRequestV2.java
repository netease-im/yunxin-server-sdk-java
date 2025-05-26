package com.netease.nim.im.server.sdk.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for batch deleting conversations
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversations/actions/conversation_ids
 */
public class BatchDeleteConversationsRequestV2 {

    /**
     * List of conversation IDs to delete (required)
     * Maximum: 100 conversations per request
     * Format examples for each item:
     * - P2P chat: account1|1|account2
     * - Advanced team: account1|2|team_id
     * - Super team: account1|3|team_id
     */
    @JSONField(serialize = false)
    private List<String> conversationIds;

    /**
     * Whether to delete the conversations' corresponding history messages
     * - true: Delete history messages along with the conversations
     * - false (default): Only delete the conversations, keep history messages
     */
    @JSONField(serialize = false)
    private Boolean clearMessage;

    /**
     * Get the list of conversation IDs
     * 
     * @return list of conversation IDs
     */
    public List<String> getConversationIds() {
        return conversationIds;
    }

    /**
     * Set the list of conversation IDs (required)
     * 
     * @param conversationIds list of conversation IDs to set
     * @return this instance for chaining
     */
    public BatchDeleteConversationsRequestV2 setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
        return this;
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
     * @return this instance for chaining
     */
    public BatchDeleteConversationsRequestV2 setClearMessage(Boolean clearMessage) {
        this.clearMessage = clearMessage;
        return this;
    }
} 