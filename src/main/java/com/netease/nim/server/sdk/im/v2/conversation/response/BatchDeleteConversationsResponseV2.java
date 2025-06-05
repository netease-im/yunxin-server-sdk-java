package com.netease.nim.server.sdk.im.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for batch deleting conversations
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversations/actions/conversation_ids
 */
public class BatchDeleteConversationsResponseV2 {
    
    /**
     * List of successfully deleted conversation IDs
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of failed deletion attempts
     */
    @JSONField(name = "failed_list")
    private List<FailedItem> failedList;
    
    /**
     * Information about a failed conversation deletion
     */
    public static class FailedItem {
        
        /**
         * The conversation ID that failed to delete
         */
        @JSONField(name = "conversation_id")
        private String conversationId;
        
        /**
         * Error code for the failure
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;
        
        public String getConversationId() {
            return conversationId;
        }
        
        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
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
    
    public List<String> getSuccessList() {
        return successList;
    }
    
    public void setSuccessList(List<String> successList) {
        this.successList = successList;
    }
    
    public List<FailedItem> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedItem> failedList) {
        this.failedList = failedList;
    }
} 