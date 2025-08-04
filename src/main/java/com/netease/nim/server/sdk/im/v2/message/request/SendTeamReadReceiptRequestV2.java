package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for sending team read receipt
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
 * 
 * This API allows you to mark messages as read in an advanced team conversation.
 * 
 * Notes:
 * - The team read receipt feature must be enabled in the Yunxin console before using this API.
 * - By default, this feature is supported for teams with up to 200 members. This limit can be extended 
 *   to up to 500 members from the console.
 * - Up to 50 messages can be marked as read in a single request.
 */
public class SendTeamReadReceiptRequestV2 {

    @JSONField(name = "from_account_id")
    private String fromAccountId;   // Account ID of the receipt sender (message receiver)
    
    @JSONField(name = "team_id")
    private Long teamId;          // ID of the advanced team
    
    @JSONField(name = "message_server_ids")
    private List<Long> messageServerIds; // Server IDs of the messages to mark as read (up to 50)
    
    /**
     * Default constructor
     */
    public SendTeamReadReceiptRequestV2() {
    }
    
    /**
     * Construct a team read receipt request
     * 
     * @param fromAccountId ID of the receipt sender (message receiver)
     * @param teamId ID of the advanced team
     * @param messageServerIds List of message server IDs to mark as read (up to 50)
     */
    public SendTeamReadReceiptRequestV2(String fromAccountId, Long teamId, List<Long> messageServerIds) {
        this.fromAccountId = fromAccountId;
        this.teamId = teamId;
        this.messageServerIds = messageServerIds;
    }
    
    // Getters and setters
    
    public String getFromAccountId() {
        return fromAccountId;
    }
    
    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    
    public Long getTeamId() {
        return teamId;
    }
    
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public List<Long> getMessageServerIds() {
        return messageServerIds;
    }
    
    public void setMessageServerIds(List<Long> messageServerIds) {
        this.messageServerIds = messageServerIds;
    }
} 