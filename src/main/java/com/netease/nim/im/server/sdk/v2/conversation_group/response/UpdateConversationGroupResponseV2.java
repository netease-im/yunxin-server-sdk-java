package com.netease.nim.im.server.sdk.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response object for updating a conversation group
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/conversation_groups/{group_id}
 */
public class UpdateConversationGroupResponseV2 {

    /**
     * Conversation group information
     */
    @JSONField(name = "conversation_group")
    private ConversationGroup conversationGroup;

    /**
     * List of conversation IDs successfully added to or removed from the group
     */
    @JSONField(name = "success_list")
    private List<String> successList;

    /**
     * List of failures when adding or removing conversations to/from the group
     */
    @JSONField(name = "failed_list")
    private List<FailItem> failedList;
    
    /**
     * Class representing conversation group information
     */
    public static class ConversationGroup {
        /**
         * Name of the conversation group
         */
        @JSONField(name = "name")
        private String name;
        
        /**
         * ID of the conversation group
         */
        @JSONField(name = "group_id")
        private Long groupId;
        
        /**
         * Custom server extension data
         */
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        /**
         * Conversation group creation time (milliseconds)
         */
        @JSONField(name = "create_time")
        private Long createTime;
        
        /**
         * Conversation group update time (milliseconds)
         */
        @JSONField(name = "update_time")
        private Long updateTime;
        
        /**
         * Get the name
         * 
         * @return the name
         */
        public String getName() {
            return name;
        }
        
        /**
         * Set the name
         * 
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
        
        /**
         * Get the group ID
         * 
         * @return the group ID
         */
        public Long getGroupId() {
            return groupId;
        }
        
        /**
         * Set the group ID
         * 
         * @param groupId the group ID to set
         */
        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }
        
        /**
         * Get the server extension data
         * 
         * @return the server extension data
         */
        public String getServerExtension() {
            return serverExtension;
        }
        
        /**
         * Set the server extension data
         * 
         * @param serverExtension the server extension data to set
         */
        public void setServerExtension(String serverExtension) {
            this.serverExtension = serverExtension;
        }
        
        /**
         * Get the creation time
         * 
         * @return the creation time
         */
        public Long getCreateTime() {
            return createTime;
        }
        
        /**
         * Set the creation time
         * 
         * @param createTime the creation time to set
         */
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        /**
         * Get the update time
         * 
         * @return the update time
         */
        public Long getUpdateTime() {
            return updateTime;
        }
        
        /**
         * Set the update time
         * 
         * @param updateTime the update time to set
         */
        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }
    
    /**
     * Class representing a failure item for adding or removing a conversation to/from a group
     */
    public static class FailItem {
        /**
         * Conversation ID that failed to be added or removed
         */
        @JSONField(name = "conversation_id")
        private String conversationId;
        
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
         * Get the conversation ID
         * 
         * @return the conversation ID
         */
        public String getConversationId() {
            return conversationId;
        }
        
        /**
         * Set the conversation ID
         * 
         * @param conversationId the conversation ID to set
         */
        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
        }
        
        /**
         * Get the error code
         * 
         * @return the error code
         */
        public Integer getErrorCode() {
            return errorCode;
        }
        
        /**
         * Set the error code
         * 
         * @param errorCode the error code to set
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
        
        /**
         * Get the error message
         * 
         * @return the error message
         */
        public String getErrorMsg() {
            return errorMsg;
        }
        
        /**
         * Set the error message
         * 
         * @param errorMsg the error message to set
         */
        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    /**
     * Get the conversation group information
     * 
     * @return the conversation group information
     */
    public ConversationGroup getConversationGroup() {
        return conversationGroup;
    }

    /**
     * Set the conversation group information
     * 
     * @param conversationGroup the conversation group information to set
     */
    public void setConversationGroup(ConversationGroup conversationGroup) {
        this.conversationGroup = conversationGroup;
    }

    /**
     * Get the success list
     * 
     * @return the success list of conversation IDs
     */
    public List<String> getSuccessList() {
        return successList;
    }

    /**
     * Set the success list
     * 
     * @param successList the success list to set
     */
    public void setSuccessList(List<String> successList) {
        this.successList = successList;
    }

    /**
     * Get the failed list
     * 
     * @return the failed list
     */
    public List<FailItem> getFailedList() {
        return failedList;
    }

    /**
     * Set the failed list
     * 
     * @param failedList the failed list to set
     */
    public void setFailedList(List<FailItem> failedList) {
        this.failedList = failedList;
    }
} 