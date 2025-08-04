package com.netease.nim.server.sdk.im.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class UpdateConversationRequestV2 {

    
    @JSONField(name = "conversation_id")
    private String conversationId;

    
    @JSONField(name = "server_extension")
    private String serverExtension;

    
    public String getConversationId() {
        return conversationId;
    }

    
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    
    public String getServerExtension() {
        return serverExtension;
    }

    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }
}