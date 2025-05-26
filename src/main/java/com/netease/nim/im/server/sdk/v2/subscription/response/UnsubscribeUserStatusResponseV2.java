package com.netease.nim.im.server.sdk.v2.subscription.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for unsubscribing from user status events
 */
public class UnsubscribeUserStatusResponseV2 {
    
    /**
     * List of failed unsubscription accounts
     */
    @JSONField(name = "failed_list")
    private List<FailedUnsubscription> failedList;
    
    /**
     * Default constructor
     */
    public UnsubscribeUserStatusResponseV2() {
    }
    
    /**
     * Get list of failed unsubscriptions
     * 
     * @return List of failed unsubscription details
     */
    public List<FailedUnsubscription> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of failed unsubscriptions
     * 
     * @param failedList List of failed unsubscription details
     */
    public void setFailedList(List<FailedUnsubscription> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Details for a failed unsubscription
     */
    public static class FailedUnsubscription {
        
        /**
         * Account ID for which the unsubscription failed
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code for the failed unsubscription
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
        public FailedUnsubscription() {
        }
        
        /**
         * Get account ID
         * 
         * @return Account ID for which the unsubscription failed
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId Account ID for which the unsubscription failed
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get error code
         * 
         * @return Error code for the failed unsubscription
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode Error code for the failed unsubscription
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