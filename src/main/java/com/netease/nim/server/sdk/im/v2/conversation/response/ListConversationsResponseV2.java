package com.netease.nim.server.sdk.im.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class ListConversationsResponseV2 {

    @JSONField(name = "has_more")
    private Boolean hasMore;

    @JSONField(name = "next_token")
    private String nextToken;

    @JSONField(name = "items")
    private List<ConversationItem> items;

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

    public List<ConversationItem> getItems() {
        return items;
    }

    public void setItems(List<ConversationItem> items) {
        this.items = items;
    }

    public static class ConversationItem {
        @JSONField(name = "conversation_id")
        private String conversationId;

        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "receiver_id")
        private String receiverId;

        @JSONField(name = "type")
        private Integer type;

        @JSONField(name = "stick_top")
        private Boolean stickTop;

        @JSONField(name = "group_ids")
        private List<Long> groupIds;

        @JSONField(name = "server_extension")
        private String serverExtension;

        @JSONField(name = "message_state")
        private Integer messageState;

        @JSONField(name = "last_message")
        private GetConversationResponseV2.LastMessage lastMessage;

        @JSONField(name = "revoke_notification")
        private GetConversationResponseV2.RevokeMessage revokeMessage;

        @JSONField(name = "unread_count")
        private Integer unreadCount;

        @JSONField(name = "sort_order")
        private Long sortOrder;

        @JSONField(name = "create_time")
        private Long createTime;

        @JSONField(name = "update_time")
        private Long updateTime;

        @JSONField(name = "last_read_time")
        private Long lastReadTime;

        public String getConversationId() {
            return conversationId;
        }

        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public String getReceiverId() {
            return receiverId;
        }

        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Boolean getStickTop() {
            return stickTop;
        }

        public void setStickTop(Boolean stickTop) {
            this.stickTop = stickTop;
        }

        public List<Long> getGroupIds() {
            return groupIds;
        }

        public void setGroupIds(List<Long> groupIds) {
            this.groupIds = groupIds;
        }

        public String getServerExtension() {
            return serverExtension;
        }

        public void setServerExtension(String serverExtension) {
            this.serverExtension = serverExtension;
        }

        public Integer getMessageState() {
            return messageState;
        }

        public void setMessageState(Integer messageState) {
            this.messageState = messageState;
        }

        public GetConversationResponseV2.LastMessage getLastMessage() {
            return lastMessage;
        }

        public void setLastMessage(GetConversationResponseV2.LastMessage lastMessage) {
            this.lastMessage = lastMessage;
        }

        public GetConversationResponseV2.RevokeMessage getRevokeMessage() {
            return revokeMessage;
        }

        public void setRevokeMessage(GetConversationResponseV2.RevokeMessage revokeMessage) {
            this.revokeMessage = revokeMessage;
        }

        public Integer getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(Integer unreadCount) {
            this.unreadCount = unreadCount;
        }

        public Long getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Long sortOrder) {
            this.sortOrder = sortOrder;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        public Long getLastReadTime() {
            return lastReadTime;
        }

        public void setLastReadTime(Long lastReadTime) {
            this.lastReadTime = lastReadTime;
        }
    }
} 