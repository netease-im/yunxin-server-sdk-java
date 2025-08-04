package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class BatchQueryQuickCommentsResponseV2 {
    
    @JSONField(name = "success_list")
    private List<SuccessResult> successList;            // 查询成功的评论信息列表
    
    @JSONField(name = "failed_list")
    private List<FailedResult> failedList;              // 查询失败的消息列表
    
    
    public static class SuccessResult {
        
        @JSONField(name = "conversation_type")
        private Integer conversationType;                // 会话类型。1：单聊；2：高级群；3：超大群
        
        @JSONField(name = "sender_id")
        private String senderId;                         // 消息的发送者 ID
        
        @JSONField(name = "receiver_id")
        private String receiverId;                       // 消息的接收者 ID
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;                    // 消息的服务器 ID
        
        @JSONField(name = "message_client_id")
        private String messageClientId;                  // 消息的客户端 ID
        
        @JSONField(name = "create_time")
        private Long createTime;                         // 消息的发送时间
        
        @JSONField(name = "comments")
        private List<Comment> comments;                  // 消息的快捷评论信息
        
        
        public static class Comment {
            
            @JSONField(name = "operator_id")
            private String operatorId;                   // 评论的用户账号 ID
            
            @JSONField(name = "index")
            private Long index;                          // 快捷评论类型，必须大于 0
            
            @JSONField(name = "extension")
            private String extension;                    // 快捷评论的扩展字段，JSON 格式
            
            @JSONField(name = "time")
            private Long time;                           // 添加快捷评论的时间
            
            public String getOperatorId() {
                return operatorId;
            }
            
            public void setOperatorId(String operatorId) {
                this.operatorId = operatorId;
            }
            
            public Long getIndex() {
                return index;
            }
            
            public void setIndex(Long index) {
                this.index = index;
            }
            
            public String getExtension() {
                return extension;
            }
            
            public void setExtension(String extension) {
                this.extension = extension;
            }
            
            public Long getTime() {
                return time;
            }
            
            public void setTime(Long time) {
                this.time = time;
            }
        }
        
        public Integer getConversationType() {
            return conversationType;
        }
        
        public void setConversationType(Integer conversationType) {
            this.conversationType = conversationType;
        }
        
        public String getSenderId() {
            return senderId;
        }
        
        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }
        
        public String getReceiverId() {
            return receiverId;
        }
        
        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }
        
        public Long getMessageServerId() {
            return messageServerId;
        }
        
        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }
        
        public String getMessageClientId() {
            return messageClientId;
        }
        
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        public List<Comment> getComments() {
            return comments;
        }
        
        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }
    }
    
    
    public static class FailedResult {
        
        @JSONField(name = "conversation_type")
        private Integer conversationType;                // 会话类型。1：单聊；2：高级群；3：超大群
        
        @JSONField(name = "sender_id")
        private String senderId;                         // 消息的发送者 ID
        
        @JSONField(name = "receiver_id")
        private String receiverId;                       // 消息的接收者 ID
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;                    // 消息的服务器 ID
        
        @JSONField(name = "message_client_id")
        private String messageClientId;                  // 消息的客户端 ID
        
        @JSONField(name = "create_time")
        private Long createTime;                         // 消息的发送时间
        
        @JSONField(name = "error_code")
        private Integer errorCode;                       // 错误码
        
        @JSONField(name = "error_msg")
        private String errorMsg;                         // 错误信息
        
        public Integer getConversationType() {
            return conversationType;
        }
        
        public void setConversationType(Integer conversationType) {
            this.conversationType = conversationType;
        }
        
        public String getSenderId() {
            return senderId;
        }
        
        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }
        
        public String getReceiverId() {
            return receiverId;
        }
        
        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }
        
        public Long getMessageServerId() {
            return messageServerId;
        }
        
        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }
        
        public String getMessageClientId() {
            return messageClientId;
        }
        
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
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
    
    public List<SuccessResult> getSuccessList() {
        return successList;
    }
    
    public void setSuccessList(List<SuccessResult> successList) {
        this.successList = successList;
    }
    
    public List<FailedResult> getFailedList() {
        return failedList;
    }
    
    public void setFailedList(List<FailedResult> failedList) {
        this.failedList = failedList;
    }
} 