package com.netease.nim.im.server.sdk.v2.mute.response;

import java.util.List;

/**
 * Response for listing mute contacts
 */
public class ListMuteContactsResponseV2 {
    
    /**
     * Indicates if there are more results available
     */
    private Boolean hasMore;
    
    /**
     * Token for next page of results
     */
    private String nextToken;
    
    /**
     * List of contact account IDs that are muted
     */
    private List<String> items;
    
    public Boolean getHasMore() {
        return hasMore;
    }
    
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    public String getNextToken() {
        return nextToken;
    }
    
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    public List<String> getItems() {
        return items;
    }
    
    public void setItems(List<String> items) {
        this.items = items;
    }
} 