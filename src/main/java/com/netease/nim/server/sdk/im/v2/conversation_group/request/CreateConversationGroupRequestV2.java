package com.netease.nim.server.sdk.im.v2.conversation_group.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class CreateConversationGroupRequestV2 {

    
    @JSONField(name = "account_id")
    private String accountId;

    
    @JSONField(name = "name")
    private String name;

    
    @JSONField(name = "server_extension")
    private String serverExtension;

    
    @JSONField(name = "conversation_ids")
    private List<String> conversationIds;

    
    public CreateConversationGroupRequestV2() {
    }

    
    public CreateConversationGroupRequestV2(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    
    public CreateConversationGroupRequestV2(String accountId, String name, String serverExtension, List<String> conversationIds) {
        this.accountId = accountId;
        this.name = name;
        this.serverExtension = serverExtension;
        this.conversationIds = conversationIds;
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

    
    public List<String> getConversationIds() {
        return conversationIds;
    }

    
    public void setConversationIds(List<String> conversationIds) {
        this.conversationIds = conversationIds;
    }
} 