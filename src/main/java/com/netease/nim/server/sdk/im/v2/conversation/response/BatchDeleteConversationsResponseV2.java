package com.netease.nim.server.sdk.im.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchDeleteConversationsResponseV2 {
    
    
    @JSONField(name = "success_list")
    private List<String> successList;
    
    
    @JSONField(name = "failed_list")
    private List<FailedItem> failedList;
    
    
    public static class FailedItem {
        
        
        @JSONField(name = "conversation_id")
        private String conversationId;
        
        
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        
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