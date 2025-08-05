package com.netease.nim.server.sdk.im.v2.chatroom_message.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;
import java.util.Map;

public class QueryChatroomHistoryMessagesResponseV2 {

    @JSONField(name = "has_more")
    private Boolean hasMore;

    @JSONField(name = "next_token")
    private String nextToken;

    @JSONField(name = "items")
    private List<MessageItem> items;

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

    public List<MessageItem> getItems() {
        return items;
    }

    public void setItems(List<MessageItem> items) {
        this.items = items;
    }

    public static class MessageItem {

        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "message_type")
        private Integer messageType;

        @JSONField(name = "create_time")
        private Long createTime;

        @JSONField(name = "message_client_id")
        private String messageClientId;

        @JSONField(name = "sender_client_type")
        private Integer senderClientType;

        @JSONField(name = "text")
        private String text;

        @JSONField(name = "attachment")
        private Map<?, ?> attachment;

        @JSONField(name = "extension")
        private String extension;

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public Integer getMessageType() {
            return messageType;
        }

        public void setMessageType(Integer messageType) {
            this.messageType = messageType;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public String getMessageClientId() {
            return messageClientId;
        }

        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }

        public Integer getSenderClientType() {
            return senderClientType;
        }

        public void setSenderClientType(Integer senderClientType) {
            this.senderClientType = senderClientType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Map<?, ?> getAttachment() {
            return attachment;
        }

        public void setAttachment(Map<?, ?> attachment) {
            this.attachment = attachment;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }
    }



    public static class ThreadReply {
        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "receiver_id")
        private String receiverId;

        @JSONField(name = "create_time")
        private Long createTime;

        @JSONField(name = "message_server_id")
        private Long messageServerId;

        @JSONField(name = "message_client_id")
        private String messageClientId;

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

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getMessageServerId() {
            return messageServerId;
        }

        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }

        public String getMessageClientId() {
            return messageClientId;
        }

        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
    }
}