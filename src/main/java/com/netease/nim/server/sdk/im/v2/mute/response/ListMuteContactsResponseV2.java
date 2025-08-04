package com.netease.nim.server.sdk.im.v2.mute.response;

import java.util.List;


public class ListMuteContactsResponseV2 {
    
    
    private Boolean hasMore;
    
    
    private String nextToken;
    
    
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