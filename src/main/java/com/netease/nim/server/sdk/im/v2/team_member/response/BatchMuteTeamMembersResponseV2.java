package com.netease.nim.server.sdk.im.v2.team_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchMuteTeamMembersResponseV2 {
    
    
    @JSONField(name = "success_list")
    private List<String> successList;
    
    
    @JSONField(name = "failed_list")
    private List<FailedMute> failedList;
    
    
    public static class FailedMute {
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
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