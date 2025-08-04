package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class SendTeamReadReceiptResponseV2 {
    
    @JSONField(name = "success_list")
    private List<Long> successList; // List of message IDs that were successfully marked as read
    
    @JSONField(name = "failed_list")
    private List<Long> failedList;  // List of message IDs that failed to be marked as read
    
    
    public SendTeamReadReceiptResponseV2() {
    }
    
    
    public List<Long> getSuccessList() {
        return successList;
    }
    
    
    public void setSuccessList(List<Long> successList) {
        this.successList = successList;
    }
    
    
    public List<Long> getFailedList() {
        return failedList;
    }
    
    
    public void setFailedList(List<Long> failedList) {
        this.failedList = failedList;
    }
} 