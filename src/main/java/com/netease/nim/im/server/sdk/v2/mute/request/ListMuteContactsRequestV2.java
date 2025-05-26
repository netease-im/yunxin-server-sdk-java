package com.netease.nim.im.server.sdk.v2.mute.request;

/**
 * Request for listing mute contacts
 */
public class ListMuteContactsRequestV2 {
    
    /**
     * Account ID to list mute contacts for
     */
    private String accountId;
    
    /**
     * Page token for pagination
     */
    private String pageToken;
    
    /**
     * Limit for number of results per page (default and max is 100)
     */
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