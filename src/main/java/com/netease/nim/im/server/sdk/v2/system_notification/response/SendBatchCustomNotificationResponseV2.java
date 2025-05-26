package com.netease.nim.im.server.sdk.v2.system_notification.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for sending batch custom system notifications
 */
public class SendBatchCustomNotificationResponseV2 {
    
    /**
     * List of successfully sent notifications
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of failed notifications
     */
    @JSONField(name = "failed_list")
    private List<FailedNotification> failedList;
    
    /**
     * Default constructor
     */
    public SendBatchCustomNotificationResponseV2() {
    }
    
    /**
     * Get list of successfully sent notifications
     * 
     * @return List of account IDs for which notifications were successfully sent
     */
    public List<String> getSuccessList() {
        return successList;
    }
    
    /**
     * Set list of successfully sent notifications
     * 
     * @param successList List of account IDs for which notifications were successfully sent
     */
    public void setSuccessList(List<String> successList) {
        this.successList = successList;
    }
    
    /**
     * Get list of failed notifications
     * 
     * @return List of failed notifications with error details
     */
    public List<FailedNotification> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of failed notifications
     * 
     * @param failedList List of failed notifications with error details
     */
    public void setFailedList(List<FailedNotification> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Details for a failed notification
     */
    public static class FailedNotification {
        
        /**
         * Account ID for which the notification failed
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        /**
         * Error code
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Default constructor
         */
        public FailedNotification() {
        }
        
        /**
         * Get account ID
         * 
         * @return Account ID for which the notification failed
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId Account ID for which the notification failed
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
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
        
        /**
         * Get error code
         * 
         * @return Error code
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode Error code
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
    }
} 