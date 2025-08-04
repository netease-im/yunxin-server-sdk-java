package com.netease.nim.server.sdk.im.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class StickTopConversationRequestV2 {
    

    @JSONField(name = "conversation_id")
    private String conversationId;
    

    @JSONField(name = "top_type")
    private Integer topType;
    


    public StickTopConversationRequestV2(String conversationId, Integer topType) {
        this.conversationId = conversationId;
        this.topType = topType;
    }
    


    public static StickTopConversationRequestV2 createPinRequest(String conversationId) {
        return new StickTopConversationRequestV2(conversationId, 1);
    }
    

    public static StickTopConversationRequestV2 createUnpinRequest(String conversationId) {
        return new StickTopConversationRequestV2(conversationId, 0);
    }
    

    public StickTopConversationRequestV2() {
    }
    

    public String getConversationId() {
        return conversationId;
    }
    

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    

    public Integer getTopType() {
        return topType;
    }
    

    public void setTopType(Integer topType) {
        this.topType = topType;
    }
} 