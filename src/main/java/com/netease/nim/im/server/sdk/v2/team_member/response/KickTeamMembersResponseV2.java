package com.netease.nim.im.server.sdk.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for kicking members from a team
 * 
 * This class represents the response containing the results of the kick operation.
 */
public class KickTeamMembersResponseV2 {
    
    /**
     * List of account IDs that were successfully kicked
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of failed kick operations
     */
    @JSONField(name = "failed_list")
    private List<FailedKick> failedList;
    
    /**
     * Information about a failed kick operation
     */
    public static class FailedKick {
        /**
         * Account ID that could not be kicked
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
    
    public List<FailedKick> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedKick> failedList) {
        this.failedList = failedList;
    }
} 