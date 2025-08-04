package com.netease.nim.server.sdk.im.v2.conversation.request;


public class GetConversationRequestV2 {
    
    
    private String conversationId;
    
    
    public GetConversationRequestV2(String conversationId) {
        this.conversationId = conversationId;
    }
    
    
    public GetConversationRequestV2() {
    }
    
    
    public String getConversationId() {
        return conversationId;
    }
    
    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
} 