package com.netease.nim.server.sdk.im.v2.subscription.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UnsubscribeUserStatusResponseV2 {
    
    
    @JSONField(name = "failed_list")
    private List<FailedUnsubscription> failedList;
    
    
    public UnsubscribeUserStatusResponseV2() {
    }
    
    
    public List<FailedUnsubscription> getFailedList() {
        return failedList;
    }
    
    
    public void setFailedList(List<FailedUnsubscription> failedList) {
        this.failedList = failedList;
    }
    
    
    public static class FailedUnsubscription {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        
        public FailedUnsubscription() {
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