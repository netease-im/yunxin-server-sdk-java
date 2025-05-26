package com.netease.nim.im.server.sdk.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for sending team read receipt
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
 */
public class SendTeamReadReceiptResponseV2 {
    
    @JSONField(name = "success_list")
    private List<Long> successList; // List of message IDs that were successfully marked as read
    
    @JSONField(name = "failed_list")
    private List<Long> failedList;  // List of message IDs that failed to be marked as read
    
    /**
     * Default constructor
     */
    public SendTeamReadReceiptResponseV2() {
    }
    
    /**
     * Get the list of message IDs that were successfully marked as read
     * 
     * @return List of successful message IDs
     */
    public List<Long> getSuccessList() {
        return successList;
    }
    
    /**
     * Set the list of message IDs that were successfully marked as read
     * 
     * @param successList List of successful message IDs
     */
    public void setSuccessList(List<Long> successList) {
        this.successList = successList;
    }
    
    /**
     * Get the list of message IDs that failed to be marked as read
     * 
     * @return List of failed message IDs
     */
    public List<Long> getFailedList() {
        return failedList;
    }
    
    /**
     * Set the list of message IDs that failed to be marked as read
     * 
     * @param failedList List of failed message IDs
     */
    public void setFailedList(List<Long> failedList) {
        this.failedList = failedList;
    }
} 