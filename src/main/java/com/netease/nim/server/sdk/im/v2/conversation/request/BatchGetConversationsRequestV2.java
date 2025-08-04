package com.netease.nim.server.sdk.im.v2.conversation.request;

import java.util.List;


public class BatchGetConversationsRequestV2 {
    
    
    private List<String> conversationIds;
    
    
    public BatchGetConversationsRequestV2(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
    
    
    public BatchGetConversationsRequestV2() {
    }
    
    
    public List<String> getConversationIds() {
        return conversationIds;
    }
    
    
    public void setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
} 