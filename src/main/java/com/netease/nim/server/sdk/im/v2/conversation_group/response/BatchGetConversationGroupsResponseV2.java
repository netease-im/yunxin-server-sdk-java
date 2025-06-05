package com.netease.nim.server.sdk.im.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response object for batch getting conversation groups
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups/actions/group_ids
 */
public class BatchGetConversationGroupsResponseV2 {

    /**
     * List of conversation groups successfully retrieved
     */
    @JSONField(name = "success_list")
    private List<ConversationGroup> successList;

    /**
     * List of failures when retrieving conversation groups
     */
    @JSONField(name = "fail_list")
    private List<FailItem> failList;
    
    /**
     * Class representing a conversation group
     */
    public static class ConversationGroup {
        /**
         * ID of the conversation group
         */
        @JSONField(name = "group_id")
        private Long groupId;
        
        /**
         * Name of the conversation group
         */
        @JSONField(name = "name")
        private String name;
        
        /**
         * Custom server extension data
         */
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        /**
         * Account ID that owns the group
         */
        @JSONField(name = "account_id")
        private String accountId;
        
        /**
         * List of conversation IDs in the group
         */
        @JSONField(name = "conversation_ids")
        private List<String> conversationIds;
        
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
         * Get the account ID
         * 
         * @return the account ID
         */
        public String getAccountId() {
            return accountId;
        }
        
        /**
         * Set the account ID
         * 
         * @param accountId the account ID to set
         */
        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
        
        /**
         * Get the conversation IDs
         * 
         * @return the list of conversation IDs
         */
        public List<String> getConversationIds() {
            return conversationIds;
        }
        
        /**
         * Set the conversation IDs
         * 
         * @param conversationIds the list of conversation IDs to set
         */
        public void setConversationIds(List<String> conversationIds) {
            this.conversationIds = conversationIds;
        }
    }
    
    /**
     * Class representing a failure item for retrieving a conversation group
     */
    public static class FailItem {
        /**
         * Group ID that failed to be retrieved
         */
        @JSONField(name = "group_id")
        private Long groupId;
        
        /**
         * Error code for the failure
         */
        @JSONField(name = "code")
        private Integer code;
        
        /**
         * Error message for the failure
         */
        @JSONField(name = "msg")
        private String msg;
        
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
         * Get the error code
         * 
         * @return the error code
         */
        public Integer getCode() {
            return code;
        }
        
        /**
         * Set the error code
         * 
         * @param code the error code to set
         */
        public void setCode(Integer code) {
            this.code = code;
        }
        
        /**
         * Get the error message
         * 
         * @return the error message
         */
        public String getMsg() {
            return msg;
        }
        
        /**
         * Set the error message
         * 
         * @param msg the error message to set
         */
        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    /**
     * Get the success list
     * 
     * @return the success list of conversation groups
     */
    public List<ConversationGroup> getSuccessList() {
        return successList;
    }

    /**
     * Set the success list
     * 
     * @param successList the success list to set
     */
    public void setSuccessList(List<ConversationGroup> successList) {
        this.successList = successList;
    }

    /**
     * Get the fail list
     * 
     * @return the fail list
     */
    public List<FailItem> getFailList() {
        return failList;
    }

    /**
     * Set the fail list
     * 
     * @param failList the fail list to set
     */
    public void setFailList(List<FailItem> failList) {
        this.failList = failList;
    }
} 