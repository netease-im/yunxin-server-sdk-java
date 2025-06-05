package com.netease.nim.server.sdk.im.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for batch muting team members
 * 
 * This class represents the response containing the results of the batch mute operation.
 */
public class BatchMuteTeamMembersResponseV2 {
    
    /**
     * List of account IDs that were successfully muted/unmuted
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of failed mute/unmute operations
     */
    @JSONField(name = "failed_list")
    private List<FailedMute> failedList;
    
    /**
     * Information about a failed mute/unmute operation
     */
    public static class FailedMute {
        /**
         * Account ID that could not be muted/unmuted
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        // Getters and Setters
        
        public String getAccountId() {
            return accountId;
        }
        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        public Integer getErrorCode() {
            return errorCode;
        }
        
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
        
        public String getErrorMsg() {
            return errorMsg;
        }
        
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
    
    // Getters and Setters for the root class
    
    public List<String> getSuccessList() {
        return successList;
    }
    
    public void setSuccessList(List<String> successList) {
        this.successList = successList;
    }
    
    public List<FailedMute> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedMute> failedList) {
        this.failedList = failedList;
    }
} 