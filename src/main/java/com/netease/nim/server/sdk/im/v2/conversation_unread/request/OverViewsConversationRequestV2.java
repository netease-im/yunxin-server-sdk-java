package com.netease.nim.server.sdk.im.v2.conversation_unread.request;


public class OverViewsConversationRequestV2 {

    
    private String accountId;

    
    public OverViewsConversationRequestV2() {
    }
    
    
    public OverViewsConversationRequestV2(String accountId) {
        this.accountId = accountId;
    }

    
    public String getAccountId() {
        return accountId;
    }

    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}