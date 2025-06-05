package com.netease.nim.server.sdk.im.v2.message.response;

/**
 * Response for sending P2P read receipt
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/p2p_read_receipt
 */
public class SendP2PReadReceiptResponseV2 {
    
    private Long timestamp; // Timestamp when the read receipt was sent
    
    /**
     * Default constructor
     */
    public SendP2PReadReceiptResponseV2() {
    }
    
    /**
     * Get the timestamp when the read receipt was sent
     * 
     * @return timestamp in milliseconds
     */
    public Long getTimestamp() {
        return timestamp;
    }
    
    /**
     * Set the timestamp when the read receipt was sent
     * 
     * @param timestamp timestamp in milliseconds
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
} 