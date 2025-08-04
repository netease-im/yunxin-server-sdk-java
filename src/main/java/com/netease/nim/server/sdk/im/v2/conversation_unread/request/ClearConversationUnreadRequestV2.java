package com.netease.nim.server.sdk.im.v2.conversation_unread.request;


public class ClearConversationUnreadRequestV2 {

    
    private String conversationId;

    
    public ClearConversationUnreadRequestV2() {
    }
    
    
    public ClearConversationUnreadRequestV2(String conversationId) {
        this.conversationId = conversationId;
    }

    
    public String getConversationId() {
        return conversationId;
    }

    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
} 