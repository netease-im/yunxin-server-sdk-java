package com.netease.nim.im.server.sdk.v2.conversation.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response object for creating a conversation group
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversation_groups
 */
public class CreateConversationGroupResponseV2 {

    /**
     * Conversation group information
     */
    @JSONField(name = "conversation_group")
    private ConversationGroup conversationGroup;
    
    /**
     * List of conversation IDs successfully added to the group
     */
    @JSONField(name = "success_list")
    private List<String> successList;
    
    /**
     * List of conversation IDs that failed to be added to the group
     */
    @JSONField(name = "failed_list")
    private List<FailedItem> failedList;
    
    /**
     * Conversation group information
     */
    public static class ConversationGroup {
        /**
         * Conversation group name
         */
        @JSONField(name = "name")
        private String name;
        
        /**
         * Conversation group ID
         */
        @JSONField(name = "group_id")
        private Long groupId;
        
        /**
         * Server extension information
         */
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        /**
         * Group creation time (milliseconds)
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Group update time (milliseconds)
         */
        @JSONField(name = "update_time")
        private Long updateTime;

        // Getters and Setters
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }

        public String getServerExtension() {
            return serverExtension;
        }

        public void setServerExtension(String serverExtension) {
            this.serverExtension = serverExtension;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }
    
    /**
     * Failed item information
     */
    public static class FailedItem {
        /**
         * Conversation ID that failed to be added
         */
        @JSONField(name = "conversation_id")
        private String conversationId;
        
        /**
         * Error code
         */
        @JSONField(name = "error_code")
        private Integer errorCode;
        
        /**
         * Error message
         */
        @JSONField(name = "error_msg")
        private String errorMsg;

        // Getters and Setters
        
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

    // Getters and Setters
    
    public ConversationGroup getConversationGroup() {
        return conversationGroup;
    }

    public void setConversationGroup(ConversationGroup conversationGroup) {
        this.conversationGroup = conversationGroup;
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