package com.netease.nim.server.sdk.im.v2.chatroom_message.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class QueryChatroomHistoryMessagesRequestV2 {
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "sender_id")
    private String senderId;
    
    
    @JSONField(name = "page_token")
    private String pageToken;
    
    
    @JSONField(name = "limit")
    private Integer limit;
    
    
    @JSONField(name = "descending")
    private Boolean descending;
    
    
    @JSONField(name = "message_type")
    private String messageTypes;
    
    
    public QueryChatroomHistoryMessagesRequestV2() {
    }
    
    
    public QueryChatroomHistoryMessagesRequestV2(Long roomId, String senderId, Integer limit) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.limit = limit;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public String getSenderId() {
        return senderId;
    }
    
    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
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
    
    
    public Boolean getDescending() {
        return descending;
    }
    
    
    public void setDescending(Boolean descending) {
        this.descending = descending;
    }
    
    
    public String getMessageTypes() {
        return messageTypes;
    }
    
    
    public void setMessageTypes(String messageTypes) {
        this.messageTypes = messageTypes;
    }
} 