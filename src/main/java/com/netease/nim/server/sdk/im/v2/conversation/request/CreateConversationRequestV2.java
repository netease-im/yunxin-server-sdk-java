package com.netease.nim.server.sdk.im.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class CreateConversationRequestV2 {
    
    
    @JSONField(name = "conversation_id")
    private String conversationId;
    
    
    public String getConversationId() {
        return conversationId;
    }
    
    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    
    
    public static String createP2PConversationId(String senderId, String receiverId) {
        return senderId + "|1|" + receiverId;
    }
    
    
    public static String createAdvancedTeamConversationId(String senderId, String teamId) {
        return senderId + "|2|" + teamId;
    }
    
    
    public static String createSuperTeamConversationId(String senderId, String teamId) {
        return senderId + "|3|" + teamId;
    }
} 