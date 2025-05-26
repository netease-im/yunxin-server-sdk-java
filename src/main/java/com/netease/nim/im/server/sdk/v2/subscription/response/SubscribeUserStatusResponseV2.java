package com.netease.nim.im.server.sdk.v2.subscription.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for user status subscription
 */
public class SubscribeUserStatusResponseV2 {
    
    /**
     * List of failed subscription accounts
     */
    @JSONField(name = "failed_list")
    private List<FailedSubscription> failedList;
    
    /**
     * Default constructor
     */
    public SubscribeUserStatusResponseV2() {
    }
    
    /**
     * Get list of failed subscriptions
     * 
     * @return List of failed subscription details
     */
    public List<FailedSubscription> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of failed subscriptions
     * 
     * @param failedList List of failed subscription details
     */
    public void setFailedList(List<FailedSubscription> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Details for a failed subscription
     */
    public static class FailedSubscription {
        
        /**
         * Account ID for which the subscription failed
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code for the failed subscription
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
        public FailedSubscription() {
        }
        
        /**
         * Get account ID
         * 
         * @return Account ID for which the subscription failed
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId Account ID for which the subscription failed
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get error code
         * 
         * @return Error code for the failed subscription
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode Error code for the failed subscription
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
} 