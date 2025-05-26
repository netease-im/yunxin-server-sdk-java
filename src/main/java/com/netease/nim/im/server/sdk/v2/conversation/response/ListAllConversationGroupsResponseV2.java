package com.netease.nim.im.server.sdk.v2.conversation.response;

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

    // Getters and Setters

    public List<ConversationGroup> getConversationGroups() {
        return conversationGroups;
    }

    public void setConversationGroups(List<ConversationGroup> conversationGroups) {
        this.conversationGroups = conversationGroups;
    }
} 