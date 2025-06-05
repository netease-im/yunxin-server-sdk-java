package com.netease.nim.server.sdk.im.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response object for listing all conversation groups
 * 
 * API: GET https://open.yunxinapi.com/im/v2/conversation_groups
 */
public class ListAllConversationGroupsResponseV2 {

    /**
     * List of conversation groups
     */
    @JSONField(name = "conversation_groups")
    private List<ConversationGroup> conversationGroups;
    
    /**
     * Class representing a conversation group in the list
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
     * Get the conversation groups
     * 
     * @return the list of conversation groups
     */
    public List<ConversationGroup> getConversationGroups() {
        return conversationGroups;
    }

    /**
     * Set the conversation groups
     * 
     * @param conversationGroups the list of conversation groups to set
     */
    public void setConversationGroups(List<ConversationGroup> conversationGroups) {
        this.conversationGroups = conversationGroups;
    }
} 