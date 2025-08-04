package com.netease.nim.server.sdk.im.v2.conversation_group.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchGetConversationGroupsResponseV2 {

    
    @JSONField(name = "success_list")
    private List<GetConversationGroupResponseV2> successList;

    
    @JSONField(name = "fail_list")
    private List<FailItem> failList;

    
    public static class FailItem {
        
        @JSONField(name = "group_id")
        private Long groupId;
        
        
        @JSONField(name = "code")
        private Integer code;
        
        
        @JSONField(name = "msg")
        private String msg;
        
        
        public Long getGroupId() {
            return groupId;
        }
        
        
        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }
        
        
        public Integer getCode() {
            return code;
        }
        
        
        public void setCode(Integer code) {
            this.code = code;
        }
        
        
        public String getMsg() {
            return msg;
        }
        
        
        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    
    public List<GetConversationGroupResponseV2> getSuccessList() {
        return successList;
    }

    
    public void setSuccessList(List<GetConversationGroupResponseV2> successList) {
        this.successList = successList;
    }

    
    public List<FailItem> getFailList() {
        return failList;
    }

    
    public void setFailList(List<FailItem> failList) {
        this.failList = failList;
    }
} 