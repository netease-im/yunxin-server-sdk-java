package com.netease.nim.server.sdk.im.v2.subscription.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class SubscribeUserStatusResponseV2 {
    
    
    @JSONField(name = "failed_list")
    private List<FailedSubscription> failedList;
    
    
    public SubscribeUserStatusResponseV2() {
    }
    
    
    public List<FailedSubscription> getFailedList() {
        return failedList;
    }
    
    
    public void setFailedList(List<FailedSubscription> failedList) {
        this.failedList = failedList;
    }
    
    
    public static class FailedSubscription {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        
        public FailedSubscription() {
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