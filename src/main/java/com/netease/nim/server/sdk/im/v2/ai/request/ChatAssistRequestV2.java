package com.netease.nim.server.sdk.im.v2.ai.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/**
 * AI Chat Assistant request
 */
public class ChatAssistRequestV2 implements Serializable {

    @JSONField(name = "sender_id")
    private String senderId;

    @JSONField(name = "sender_tag_list")
    private List<String> senderTagList;

    @JSONField(name = "receiver_id")
    private String receiverId;

    @JSONField(name = "receiver_tag_list")
    private List<String> receiverTagList;

    @JSONField(name = "receiver_last_message")
    private String receiverLastMessage;

    @JSONField(name = "style_list")
    private List<String> styleList;

    @JSONField(name = "history")
    private List<HistoryItem> history;

    public static class HistoryItem implements Serializable {
        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "text")
        private String text;

        public HistoryItem(String senderId, String text) {
            this.senderId = senderId;
            this.text = text;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public List<String> getSenderTagList() {
        return senderTagList;
    }

    public void setSenderTagList(List<String> senderTagList) {
        this.senderTagList = senderTagList;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public List<String> getReceiverTagList() {
        return receiverTagList;
    }

    public void setReceiverTagList(List<String> receiverTagList) {
        this.receiverTagList = receiverTagList;
    }

    public String getReceiverLastMessage() {
        return receiverLastMessage;
    }

    public void setReceiverLastMessage(String receiverLastMessage) {
        this.receiverLastMessage = receiverLastMessage;
    }

    public List<String> getStyleList() {
        return styleList;
    }

    public void setStyleList(List<String> styleList) {
        this.styleList = styleList;
    }

    public List<HistoryItem> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryItem> history) {
        this.history = history;
    }
}
