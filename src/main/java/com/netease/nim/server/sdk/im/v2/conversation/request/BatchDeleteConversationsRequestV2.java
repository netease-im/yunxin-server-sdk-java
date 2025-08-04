package com.netease.nim.server.sdk.im.v2.conversation.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchDeleteConversationsRequestV2 {

    
    @JSONField(serialize = false)
    private List<String> conversationIds;

    
    @JSONField(serialize = false)
    private Boolean clearMessage;

    
    public List<String> getConversationIds() {
        return conversationIds;
    }

    
    public void setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }

    
    public Boolean getClearMessage() {
        return clearMessage;
    }

    
    public void setClearMessage(Boolean clearMessage) {
        this.clearMessage = clearMessage;
    }
} 