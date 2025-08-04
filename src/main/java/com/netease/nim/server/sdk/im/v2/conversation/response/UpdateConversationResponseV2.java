package com.netease.nim.server.sdk.im.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;

public class UpdateConversationResponseV2 {
    /**
     * 会话 ID。
     */
    @JSONField(name = "conversation_id")
    private String conversationId;

    /**
     * 会话消息发送者的账号 ID。
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * 接收会话消息的账号 ID 或群组 ID。
     */
    @JSONField(name = "receiver_id")
    private String receiverId;

    /**
     * 会话类型，1：单聊会话；2：高级群会话；3：超大群会话。
     */
    @JSONField(name = "type")
    private Integer type;

    /**
     * 服务端扩展字段。
     */
    @JSONField(name = "server_extension")
    private String serverExtension;

    /**
     * 会话更新时间（毫秒）。
     */
    @JSONField(name = "update_time")
    private Long updateTime;

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

    public String getServerExtension() {
        return serverExtension;
    }

    public void setServerExtension(String serverExtension) {
        this.serverExtension = serverExtension;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
} 