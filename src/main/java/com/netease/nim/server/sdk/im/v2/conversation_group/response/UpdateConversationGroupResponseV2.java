package com.netease.nim.server.sdk.im.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class UpdateConversationGroupResponseV2 {

    
    @JSONField(name = "conversation_group")
    private ConversationGroup conversationGroup;

    
    @JSONField(name = "success_list")
    private List<String> successList;

    
    @JSONField(name = "failed_list")
    private List<FailItem> failedList;
    
    
    public static class ConversationGroup {
        
        @JSONField(name = "name")
        private String name;
        
        
        @JSONField(name = "group_id")
        private Long groupId;
        
        
        @JSONField(name = "server_extension")
        private String serverExtension;
        
        
        @JSONField(name = "create_time")
        private Long createTime;
        
        
        @JSONField(name = "update_time")
        private Long updateTime;
        
        
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
    
    
    public static class FailItem {
        
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

    
    public List<FailItem> getFailedList() {
        return failedList;
    }

    
    public void setFailedList(List<FailItem> failedList) {
        this.failedList = failedList;
    }
} 