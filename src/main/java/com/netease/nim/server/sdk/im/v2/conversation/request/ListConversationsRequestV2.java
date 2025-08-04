package com.netease.nim.server.sdk.im.v2.conversation.request;


public class ListConversationsRequestV2 {
    
    
    private String accountId;
    
    
    private String pageToken;
    
    
    private Integer limit;
    
    
    public ListConversationsRequestV2() {
    }
    
    
    public ListConversationsRequestV2(String accountId) {
        this.accountId = accountId;
    }
    
    
    public ListConversationsRequestV2(String accountId, String pageToken, Integer limit) {
        this.accountId = accountId;
        this.pageToken = pageToken;
        this.limit = limit;
    }
    
    
    public String getAccountId() {
        return accountId;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    
    public String getPageToken() {
        return pageToken;
    }
    
    
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    
    public Integer getLimit() {
        return limit;
    }
    
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 