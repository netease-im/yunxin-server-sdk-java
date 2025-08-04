package com.netease.nim.server.sdk.im.v2.friend.request;


public class ListFriendsRequestV2 {

    private String accountId;
    private String pageToken;
    private Integer limit;

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