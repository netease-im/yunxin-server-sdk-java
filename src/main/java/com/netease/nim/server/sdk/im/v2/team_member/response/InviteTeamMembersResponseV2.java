package com.netease.nim.server.sdk.im.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for inviting members to a team
 * 
 * This class represents the response containing the results of the invitation operation.
 */
public class InviteTeamMembersResponseV2 {
    
    /**
     * List of account IDs that were successfully invited
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of failed invitations
     */
    @JSONField(name = "failed_list")
    private List<FailedInvitation> failedList;
    
    /**
     * Information about a failed invitation
     */
    public static class FailedInvitation {
        /**
         * Account ID that could not be invited
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
    
    public List<FailedInvitation> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedInvitation> failedList) {
        this.failedList = failedList;
    }
} 