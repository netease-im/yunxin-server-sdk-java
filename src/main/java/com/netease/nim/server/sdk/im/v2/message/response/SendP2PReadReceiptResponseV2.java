package com.netease.nim.server.sdk.im.v2.message.response;


public class SendP2PReadReceiptResponseV2 {
    
    private Long timestamp; // Timestamp when the read receipt was sent
    
    
    public SendP2PReadReceiptResponseV2() {
    }
    
    
    public Long getTimestamp() {
        return timestamp;
    }
    
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
} 