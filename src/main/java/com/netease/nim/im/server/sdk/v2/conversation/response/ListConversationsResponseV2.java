package com.netease.nim.im.server.sdk.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response object for listing conversations with pagination
 */
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

    /**
     * Conversation information item
     */
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
        private LastMessage lastMessage;

        @JSONField(name = "revoke_message")
        private RevokeMessage revokeMessage;

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

        public LastMessage getLastMessage() {
            return lastMessage;
        }

        public void setLastMessage(LastMessage lastMessage) {
            this.lastMessage = lastMessage;
        }

        public RevokeMessage getRevokeMessage() {
            return revokeMessage;
        }

        public void setRevokeMessage(RevokeMessage revokeMessage) {
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

    /**
     * Last message in the conversation
     */
    public static class LastMessage {
        // This class can be expanded when the details of last_message are needed
    }

    /**
     * Revoke message details
     */
    public static class RevokeMessage {
        @JSONField(name = "server_id")
        private Long serverId;

        @JSONField(name = "attach")
        private String attach;

        @JSONField(name = "revoke_id")
        private String revokeId;

        @JSONField(name = "custom_info")
        private String customInfo;

        @JSONField(name = "revoke_type")
        private Integer revokeType;

        public Long getServerId() {
            return serverId;
        }

        public void setServerId(Long serverId) {
            this.serverId = serverId;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getRevokeId() {
            return revokeId;
        }

        public void setRevokeId(String revokeId) {
            this.revokeId = revokeId;
        }

        public String getCustomInfo() {
            return customInfo;
        }

        public void setCustomInfo(String customInfo) {
            this.customInfo = customInfo;
        }

        public Integer getRevokeType() {
            return revokeType;
        }

        public void setRevokeType(Integer revokeType) {
            this.revokeType = revokeType;
        }
    }
} 