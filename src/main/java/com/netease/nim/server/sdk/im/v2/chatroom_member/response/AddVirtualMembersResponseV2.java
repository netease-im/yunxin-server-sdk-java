package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for adding virtual members to a chatroom
 * 
 * This response contains information about successfully and unsuccessfully added virtual members.
 */
public class AddVirtualMembersResponseV2 {
    
    /**
     * List of successfully added virtual member account IDs
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of virtual members that failed to be added
     */
    @JSONField(name = "failed_list")
    private List<FailedMemberInfoV2> failedList;
    
    /**
     * Default constructor
     */
    public AddVirtualMembersResponseV2() {
    }
    
    /**
     * Get list of successfully added account IDs
     * 
     * @return list of account IDs
     */
    public List<String> getSuccessList() {
        return successList;
    }
    
    /**
     * Set list of successfully added account IDs
     * 
     * @param successList list of account IDs
     */
    public void setSuccessList(List<String> successList) {
        this.successList = successList;
    }
    
    /**
     * Get list of members that failed to be added
     * 
     * @return list of failed member information
     */
    public List<FailedMemberInfoV2> getFailedList() {
        return failedList;
    }
    
    /**
     * Set list of members that failed to be added
     * 
     * @param failedList list of failed member information
     */
    public void setFailedList(List<FailedMemberInfoV2> failedList) {
        this.failedList = failedList;
    }
    
    /**
     * Information about a virtual member that failed to be added
     */
    public static class FailedMemberInfoV2 {
        
        /**
         * Account ID of the virtual member
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * Error code for the failure
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message for the failure
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        /**
         * Default constructor
         */
        public FailedMemberInfoV2() {
        }

        /**
         * Constructor with all fields
         * 
         * @param accountId account ID
         * @param errorCode error code
         * @param errorMsg error message
         */
        public FailedMemberInfoV2(String accountId, Integer errorCode, String errorMsg) {
            this.accountId = accountId;
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }
        
        /**
         * Get account ID
         * 
         * @return account ID
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set account ID
         * 
         * @param accountId account ID
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get error code
         * 
         * @return error code
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set error code
         * 
         * @param errorCode error code
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
        
        /**
         * Get error message
         * 
         * @return error message
         */
        public String getErrorMsg() {
            return errorMsg;
        }
        
        /**
         * Set error message
         * 
         * @param errorMsg error message
         */
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
} 