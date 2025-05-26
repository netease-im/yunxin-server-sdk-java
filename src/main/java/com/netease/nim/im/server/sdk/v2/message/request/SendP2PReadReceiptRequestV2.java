package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for sending P2P read receipt
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/p2p_read_receipt
 * 
 * This API allows you to mark a message as read in a P2P conversation.
 */
public class SendP2PReadReceiptRequestV2 {

    @JSONField(name = "from_account_id")
    private String fromAccountId;   // Account ID of the receipt sender (message receiver)
    @JSONField(name = "to_account_id")
    private String toAccountId;     // Account ID of the receipt receiver (message sender)
    @JSONField(name = "message_server_id")
    private Long messageServerId;   // Server ID of the message to mark as read
    
    /**
     * Default constructor
     */
    public SendP2PReadReceiptRequestV2() {
    }
    
    /**
     * Construct a P2P read receipt request
     * 
     * @param fromAccountId ID of the receipt sender (message receiver)
     * @param toAccountId ID of the receipt receiver (message sender)
     * @param messageServerId Server ID of the message to mark as read
     */
    public SendP2PReadReceiptRequestV2(String fromAccountId, String toAccountId, Long messageServerId) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.messageServerId = messageServerId;
    }
    
    // Getters and setters
    
    public String getFromAccountId() {
        return fromAccountId;
    }
    
    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    
    public String getToAccountId() {
        return toAccountId;
    }
    
    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }
    
    public Long getMessageServerId() {
        return messageServerId;
    }
    
    public void setMessageServerId(Long messageServerId) {
        this.messageServerId = messageServerId;
    }
} 