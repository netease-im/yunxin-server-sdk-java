package com.netease.nim.server.sdk.im.v2.subscription.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

public class QueryUserStatusSubscriptionResponseV2 {
    
    @JSONField(name = "failed_list")
    private List<FailedQuery> failedList;
    @JSONField(name = "subscribes")
    private List<SubscriptionDetail> subscribes;
    
    public QueryUserStatusSubscriptionResponseV2() {
    }
    public List<FailedQuery> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<FailedQuery> failedList) {
        this.failedList = failedList;
    }
    
    
    public List<SubscriptionDetail> getSubscribes() {
        return subscribes;
    }
    
    
    public void setSubscribes(List<SubscriptionDetail> subscribes) {
        this.subscribes = subscribes;
    }
    
    
    public static class FailedQuery {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        
        public FailedQuery() {
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
    
    
    public static class SubscriptionDetail {
        
        
        @JSONField(name = "account_id")
        private String accountId;
        
        
        @JSONField(name = "event_type")
        private Integer eventType;
        
        
        @JSONField(name = "subscribe_time")
        private Long subscribeTime;
        
        
        @JSONField(name = "expire_time")
        private Long expireTime;
        
        
        public SubscriptionDetail() {
        }
        
        
        public String getAccountId() {
            return accountId;
        }
        
        
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        
        public Integer getEventType() {
            return eventType;
        }
        
        
        public void setEventType(Integer eventType) {
            this.eventType = eventType;
        }
        
        
        public Long getSubscribeTime() {
            return subscribeTime;
        }
        
        
        public void setSubscribeTime(Long subscribeTime) {
            this.subscribeTime = subscribeTime;
        }
        
        
        public Long getExpireTime() {
            return expireTime;
        }
        
        
        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }
    }
} 