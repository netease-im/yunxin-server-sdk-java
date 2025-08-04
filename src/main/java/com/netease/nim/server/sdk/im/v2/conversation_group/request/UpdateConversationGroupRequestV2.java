package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UpdateConversationGroupRequestV2 {

    
    @JSONField(name = "group_id")
    private Long groupId;

    
    @JSONField(name = "account_id")
    private String accountId;

    
    @JSONField(name = "name")
    private String name;

    
    @JSONField(name = "server_extension")
    private String serverExtension;

    
    @JSONField(name = "conversations")
    private Conversations conversations;

    
    public static class Conversations {
        
        @JSONField(name = "type")
        private Integer type;

        
        @JSONField(name = "conversation_ids")
        private List<String> conversationIds;

        
        public Integer getType() {
            return type;
        }

        
        public void setType(Integer type) {
            this.type = type;
        }

        
        public List<String> getConversationIds() {
            return conversationIds;
        }

        
        public void setConversationIds(List<String> conversationIds) {
            this.conversationIds = conversationIds;
        }
    }

    
    public UpdateConversationGroupRequestV2() {
    }

    
    public UpdateConversationGroupRequestV2(Long groupId, String accountId) {
        this.groupId = groupId;
        this.accountId = accountId;
    }

    
    public Long getGroupId() {
        return groupId;
    }

    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getServerExtension() {
        return serverExtension;
    }

    
    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }

    
    public Conversations getConversations() {
        return conversations;
    }

    
    public void setConversations(Conversations conversations) {
        this.conversations = conversations;
    }
} 