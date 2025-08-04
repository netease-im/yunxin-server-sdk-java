package com.netease.nim.server.sdk.im.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class DeleteConversationRequestV2 {

    
    @JSONField(name = "conversation_id")
    private String conversationId;

    
    private Boolean clearMessage;

    
    public String getConversationId() {
        return conversationId;
    }

    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    
    public Boolean getClearMessage() {
        return clearMessage;
    }

    
    public void setClearMessage(Boolean clearMessage) {
        this.clearMessage = clearMessage;
    }
} 