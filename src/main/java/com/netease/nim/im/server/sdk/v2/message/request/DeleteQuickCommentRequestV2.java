package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for deleting quick comment from a message
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
 */
public class DeleteQuickCommentRequestV2 {
    
    @JSONField(name = "operator_id")
    private String operatorId;            // 必选: 进行删除快捷评论操作的用户账号 ID
    
    private Long index;                   // 必选: 快捷评论类型，必须大于 0
    
    private String extension;             // 可选: 快捷评论的扩展字段，JSON 格式
    
    private Message message;              // 必选: 被指定的消息对象
    
    @JSONField(name = "push_config")
    private PushConfig pushConfig;        // 可选: 推送相关配置项
    
    /**
     * 被指定的消息对象
     */
    public static class Message {
        
        @JSONField(name = "conversation_type")
        private Integer conversationType;   // 必选: 会话类型 (1: 单聊, 2: 高级群, 3: 超大群)
        
        @JSONField(name = "sender_id")
        private String senderId;            // 必选: 消息的发送者 ID
        
        @JSONField(name = "receiver_id")
        private String receiverId;          // 必选: 消息的接收者 ID
        
        @JSONField(name = "message_server_id")
        private Long messageServerId;       // 必选: 消息的服务器 ID
        
        @JSONField(name = "message_client_id")
        private String messageClientId;     // 必选: 消息的客户端 ID
        
        @JSONField(name = "create_time")
        private Long createTime;            // 必选: 消息的发送时间
        
        /**
         * 默认构造函数
         */
        public Message() {
        }
        
        /**
         * 全参数构造函数
         * 
         * @param conversationType 会话类型
         * @param senderId 消息发送者 ID
         * @param receiverId 消息接收者 ID
         * @param messageServerId 消息服务器 ID
         * @param messageClientId 消息客户端 ID
         * @param createTime 消息创建时间
         */
        public Message(Integer conversationType, String senderId, String receiverId, 
                Long messageServerId, String messageClientId, Long createTime) {
            this.conversationType = conversationType;
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.messageServerId = messageServerId;
            this.messageClientId = messageClientId;
            this.createTime = createTime;
        }
        
        // Getters and Setters
        
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
    }
    
    /**
     * 推送相关配置项
     */
    public static class PushConfig {
        
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;        // 可选: 是否需要推送通知，默认 true
        
        @JSONField(name = "push_content")
        private String pushContent;         // 可选: 推送文案，最大长度 500 字符
        
        @JSONField(name = "push_payload")
        private String pushPayload;         // 可选: 推送 payload，JSON 格式，最大长度 2048 字符
        
        /**
         * 默认构造函数
         */
        public PushConfig() {
        }
        
        /**
         * 构造函数
         * 
         * @param pushEnabled 是否需要推送通知
         * @param pushContent 推送文案
         * @param pushPayload 推送 payload
         */
        public PushConfig(Boolean pushEnabled, String pushContent, String pushPayload) {
            this.pushEnabled = pushEnabled;
            this.pushContent = pushContent;
            this.pushPayload = pushPayload;
        }
        
        // Getters and Setters
        
        public Boolean getPushEnabled() {
            return pushEnabled;
        }
        
        public void setPushEnabled(Boolean pushEnabled) {
            this.pushEnabled = pushEnabled;
        }
        
        public String getPushContent() {
            return pushContent;
        }
        
        public void setPushContent(String pushContent) {
            this.pushContent = pushContent;
        }
        
        public String getPushPayload() {
            return pushPayload;
        }
        
        public void setPushPayload(String pushPayload) {
            this.pushPayload = pushPayload;
        }
    }
    
    /**
     * 默认构造函数
     */
    public DeleteQuickCommentRequestV2() {
    }
    
    /**
     * 构造函数（必选参数）
     * 
     * @param operatorId 进行操作的用户账号 ID
     * @param index 快捷评论类型索引
     * @param message 被指定的消息对象
     */
    public DeleteQuickCommentRequestV2(String operatorId, Long index, Message message) {
        this.operatorId = operatorId;
        this.index = index;
        this.message = message;
    }
    
    /**
     * 完整参数构造函数
     * 
     * @param operatorId 进行操作的用户账号 ID
     * @param index 快捷评论类型索引
     * @param extension 扩展字段
     * @param message 被指定的消息对象
     * @param pushConfig 推送配置
     */
    public DeleteQuickCommentRequestV2(String operatorId, Long index, String extension, 
            Message message, PushConfig pushConfig) {
        this.operatorId = operatorId;
        this.index = index;
        this.extension = extension;
        this.message = message;
        this.pushConfig = pushConfig;
    }
    
    // Getters and Setters
    
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
    
    public Message getMessage() {
        return message;
    }
    
    public void setMessage(Message message) {
        this.message = message;
    }
    
    public PushConfig getPushConfig() {
        return pushConfig;
    }
    
    public void setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
    }
} 