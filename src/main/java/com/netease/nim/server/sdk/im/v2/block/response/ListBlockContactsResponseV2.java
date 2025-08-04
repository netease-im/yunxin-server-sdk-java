package com.netease.nim.server.sdk.im.v2.block.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class ListBlockContactsResponseV2 {

    @JSONField(name = "has_more")
    private Boolean hasMore;

    @JSONField(name = "next_token")
    private String nextToken;

    @JSONField(name = "items")
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