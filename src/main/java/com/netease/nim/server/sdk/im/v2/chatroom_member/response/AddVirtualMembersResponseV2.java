package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class AddVirtualMembersResponseV2 {
    
    
    @JSONField(name = "success_list")
    private List<String> successList;
    
    
    @JSONField(name = "failed_list")
    private List<FailedMemberInfoV2> failedList;
    
    
    public AddVirtualMembersResponseV2() {
    }
    
    
    public List<String> getSuccessList() {
        return successList;
    }
    
    
    public void setSuccessList(List<String> successList) {
        this.successList = successList;
    }
    
    
    public List<FailedMemberInfoV2> getFailedList() {
        return failedList;
    }
    
    
    public void setFailedList(List<FailedMemberInfoV2> failedList) {
        this.failedList = failedList;
    }
    
    
    public static class FailedMemberInfoV2 {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        
        public FailedMemberInfoV2() {
        }

        
        public FailedMemberInfoV2(String accountId, Integer errorCode, String errorMsg) {
            this.accountId = accountId;
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }
        
        
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
} 