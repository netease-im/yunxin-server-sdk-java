package com.netease.nim.im.server.sdk.v2.friend.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response class for listing friends
 */
public class ListFriendsResponseV2 {

    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    @JSONField(name = "next_token")
    private String nextToken;
    
    @JSONField(name = "items")
    private List<FriendItemV2> items;

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

    public List<FriendItemV2> getItems() {
        return items;
    }

    public void setItems(List<FriendItemV2> items) {
        this.items = items;
    }
} 