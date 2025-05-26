package com.netease.nim.im.server.sdk.v2.subscription.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying user status subscriptions
 */
public class QueryUserStatusSubscriptionResponseV2 {
    
    /**
     * List of failed query accounts
     */
    @JSONField(name = "failed_list")
    private List<FailedQuery> failedList;
    
    /**
     * List of subscription details
     */
    @JSONField(name = "subscribes")
    private List<SubscriptionDetail> subscribes;
    
    /**
     * Default constructor
     */
    public QueryUserStatusSubscriptionResponseV2() {
    }
    
    /**
     * Get list of failed queries
     * 
     * @return List of failed query details
     */
    public List<FailedQuery> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of failed queries
     * 
     * @param failedList List of failed query details
     */
    public void setFailedList(List<FailedQuery> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Get list of subscription details
     * 
     * @return List of subscription details
     */
    public List<SubscriptionDetail> getSubscribes() {
        return subscribes;
    }
    
    /**
     * Set list of subscription details
     * 
     * @param subscribes List of subscription details
     */
    public void setSubscribes(List<SubscriptionDetail> subscribes) {
        this.subscribes = subscribes;
    }
    
    /**
     * Details for a failed query
     */
    public static class FailedQuery {
        
        /**
         * Account ID for which the query failed
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code for the failed query
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        /**
         * Default constructor
         */
        public FailedQuery() {
        }
        
        /**
         * Get account ID
         * 
         * @return Account ID for which the query failed
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId Account ID for which the query failed
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get error code
         * 
         * @return Error code for the failed query
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode Error code for the failed query
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
        
        /**
         * Get error message
         * 
         * @return Error message
         */
        public String getErrorMsg() {
            return errorMsg;
        }
        
        /**
         * Set error message
         * 
         * @param errorMsg Error message
         */
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
    
    /**
     * Details for a subscription
     */
    public static class SubscriptionDetail {
        
        /**
         * Account ID of the subscribed user
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Event type (fixed value 1 for user online status events)
         */
        @JSONField(name = "event_type")
        private Integer eventType;
        
        /**
         * Subscription time (timestamp)
         */
        @JSONField(name = "subscribe_time")
        private Long subscribeTime;
        
        /**
         * Subscription expiration time (timestamp)
         */
        @JSONField(name = "expire_time")
        private Long expireTime;
        
        /**
         * Default constructor
         */
        public SubscriptionDetail() {
        }
        
        /**
         * Get account ID
         * 
         * @return Account ID of the subscribed user
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId Account ID of the subscribed user
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get event type
         * 
         * @return Event type (fixed value 1 for user online status events)
         */
        public Integer getEventType() {
            return eventType;
        }
        
        /**
         * Set event type
         * 
         * @param eventType Event type
         */
        public void setEventType(Integer eventType) {
            this.eventType = eventType;
        }
        
        /**
         * Get subscription time
         * 
         * @return Subscription time (timestamp)
         */
        public Long getSubscribeTime() {
            return subscribeTime;
        }
        
        /**
         * Set subscription time
         * 
         * @param subscribeTime Subscription time (timestamp)
         */
        public void setSubscribeTime(Long subscribeTime) {
            this.subscribeTime = subscribeTime;
        }
        
        /**
         * Get expiration time
         * 
         * @return Subscription expiration time (timestamp)
         */
        public Long getExpireTime() {
            return expireTime;
        }
        
        /**
         * Set expiration time
         * 
         * @param expireTime Subscription expiration time (timestamp)
         */
        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }
    }
} 