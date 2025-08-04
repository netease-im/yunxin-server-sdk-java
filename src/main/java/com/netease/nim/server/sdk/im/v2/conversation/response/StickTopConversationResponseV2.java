package com.netease.nim.server.sdk.im.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;

public class StickTopConversationResponseV2 {
    /**
     * 会话类型，1：单聊会话；2：高级群会话；3：超大群会话。
     */
    @JSONField(name = "type")
    private Integer type;

    /**
     * 会话 ID。
     */
    @JSONField(name = "conversation_id")
    private String conversationId;

    /**
     * 会话我方的账号 ID。
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * 会话对方的账号 ID 或群组 ID。
     */
    @JSONField(name = "receiver_id")
    private String receiverId;

    /**
     * 是否为置顶会话。
     */
    @JSONField(name = "stick_top")
    private Boolean stickTop;

    /**
     * 会话排序字段。
     */
    @JSONField(name = "sort_order")
    private Long sortOrder;

    /**
     * 会话更新时间（毫秒）。
     */
    @JSONField(name = "update_time")
    private Long updateTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public Boolean getStickTop() {
        return stickTop;
    }

    public void setStickTop(Boolean stickTop) {
        this.stickTop = stickTop;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
} 