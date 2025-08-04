package com.netease.nim.server.sdk.im.v2.friend.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


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

    
    public static class FriendItemV2 {

        @JSONField(name = "friend_account_id")
        private String friendAccountId;

        @JSONField(name = "alias")
        private String alias;

        @JSONField(name = "extension")
        private String extension;

        @JSONField(name = "customer_extension")
        private String customerExtension;

        public String getFriendAccountId() {
            return friendAccountId;
        }

        public void setFriendAccountId(String friendAccountId) {
            this.friendAccountId = friendAccountId;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public String getCustomerExtension() {
            return customerExtension;
        }

        public void setCustomerExtension(String customerExtension) {
            this.customerExtension = customerExtension;
        }
    }
}