package com.netease.nim.server.sdk.im.v2.chatroom_message.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;
import java.util.Map;

/**
 * Request for sending a message to a chatroom
 */
public class SendChatroomMessageRequestV2 {
    
    /**
     * ID of the chatroom
     */
    @JSONField(serialize = false)  // Not serialized to JSON as it's used in URL path
    private Long roomId;
    
    /**
     * ID of the account sending the message
     */
    @JSONField(name = "sender_id")
    private String senderId;
    
    /**
     * List of account IDs to receive the message (for direct messages)
     * If non-empty, this is considered a directed message, which is not stored as history
     */
    @JSONField(name = "receiver_ids")
    private List<String> receiverIds;
    
    /**
     * Flag to indicate if this is a resend message
     * 0: not a resend (default), 1: resend (deduplicated by messageClientId)
     */
    @JSONField(name = "resend_flag")
    private Integer resendFlag;
    
    /**
     * Developer extension parameter in JSON format
     */
    @JSONField(name = "extension")
    private String extension;
    
    /**
     * Message details
     */
    @JSONField(name = "message")
    private MessageBody message;
    
    /**
     * Message configuration
     */
    @JSONField(name = "message_config")
    private MessageConfig messageConfig;
    
    /**
     * Route configuration for message forwarding
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    
    /**
     * Anti-spam configuration
     */
    @JSONField(name = "antispam_config")
    private AntispamConfig antispamConfig;
    
    /**
     * AI parameters for digital human functionality
     */
    @JSONField(name = "ai_params")
    private AiParams aiParams;
    
    /**
     * Default constructor
     */
    public SendChatroomMessageRequestV2() {
    }
    
    /**
     * Constructor with required fields
     * 
     * @param senderId Sender account ID
     * @param message Message body
     */
    public SendChatroomMessageRequestV2(String senderId, MessageBody message) {
        this.senderId = senderId;
        this.message = message;
    }
    
    /**
     * Constructor with chatroom ID and required fields
     * 
     * @param roomId Chatroom ID
     * @param senderId Sender account ID
     * @param message Message body
     */
    public SendChatroomMessageRequestV2(Long roomId, String senderId, MessageBody message) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.message = message;
    }
    
    // Getters and Setters
    
    public Long getRoomId() {
        return roomId;
    }
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    public String getSenderId() {
        return senderId;
    }
    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    
    public List<String> getReceiverIds() {
        return receiverIds;
    }
    
    public void setReceiverIds(List<String> receiverIds) {
        this.receiverIds = receiverIds;
    }
    
    public Integer getResendFlag() {
        return resendFlag;
    }
    
    public void setResendFlag(Integer resendFlag) {
        this.resendFlag = resendFlag;
    }
    
    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public MessageBody getMessage() {
        return message;
    }
    
    public void setMessage(MessageBody message) {
        this.message = message;
    }
    
    public MessageConfig getMessageConfig() {
        return messageConfig;
    }
    
    public void setMessageConfig(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }
    
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }
    
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
    
    public AntispamConfig getAntispamConfig() {
        return antispamConfig;
    }
    
    public void setAntispamConfig(AntispamConfig antispamConfig) {
        this.antispamConfig = antispamConfig;
    }
    
    public AiParams getAiParams() {
        return aiParams;
    }
    
    public void setAiParams(AiParams aiParams) {
        this.aiParams = aiParams;
    }
    
    /**
     * Message body class
     */
    public static class MessageBody {
        
        /**
         * Client-generated message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;
        
        /**
         * Message type
         * 0: Text message
         * 1: Image message
         * 2: Audio message
         * 3: Video message
         * 4: Location message
         * 6: File message
         * 10: Tip message
         * 100: Custom message
         */
        @JSONField(name = "message_type")
        private Integer messageType;
        
        /**
         * Custom message subtype, valid when messageType = 100
         */
        @JSONField(name = "sub_type")
        private Integer subType;
        
        /**
         * Text content for text/tip messages, or description for other message types
         */
        @JSONField(name = "text")
        private String text;
        
        /**
         * Properties for non-text/tip messages or custom message content
         */
        @JSONField(name = "attachment")
        private Object attachment;
        
        /**
         * Spatial coordinate X for spatial messages
         */
        @JSONField(name = "location_x")
        private Double locationX;
        
        /**
         * Spatial coordinate Y for spatial messages
         */
        @JSONField(name = "location_y")
        private Double locationY;
        
        /**
         * Spatial coordinate Z for spatial messages
         */
        @JSONField(name = "location_z")
        private Double locationZ;
        
        /**
         * Default constructor
         */
        public MessageBody() {
        }
        
        /**
         * Constructor with required fields
         * 
         * @param messageClientId Client message ID
         * @param messageType Message type
         */
        public MessageBody(String messageClientId, Integer messageType) {
            this.messageClientId = messageClientId;
            this.messageType = messageType;
        }
        
        // Getters and Setters
        
        public String getMessageClientId() {
            return messageClientId;
        }
        
        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
        
        public Integer getMessageType() {
            return messageType;
        }
        
        public void setMessageType(Integer messageType) {
            this.messageType = messageType;
        }
        
        public Integer getSubType() {
            return subType;
        }
        
        public void setSubType(Integer subType) {
            this.subType = subType;
        }
        
        public String getText() {
            return text;
        }
        
        public void setText(String text) {
            this.text = text;
        }
        
        public Object getAttachment() {
            return attachment;
        }
        
        public void setAttachment(Object attachment) {
            this.attachment = attachment;
        }
        
        public Double getLocationX() {
            return locationX;
        }
        
        public void setLocationX(Double locationX) {
            this.locationX = locationX;
        }
        
        public Double getLocationY() {
            return locationY;
        }
        
        public void setLocationY(Double locationY) {
            this.locationY = locationY;
        }
        
        public Double getLocationZ() {
            return locationZ;
        }
        
        public void setLocationZ(Double locationZ) {
            this.locationZ = locationZ;
        }
    }
    
    /**
     * Message configuration class
     */
    public static class MessageConfig {
        
        /**
         * Whether to ignore temporary chat bans in the chatroom
         */
        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;
        
        /**
         * Whether to store the message in cloud history
         */
        @JSONField(name = "history_enabled")
        private Boolean historyEnabled;
        
        /**
         * Whether to send as high priority message
         */
        @JSONField(name = "high_priority")
        private Boolean highPriority;
        
        /**
         * Whether to resend high priority messages when users rejoin
         */
        @JSONField(name = "need_high_priority_msg_resend")
        private Boolean needHighPriorityMsgResend;
        
        /**
         * Message discard probability (0-9999)
         */
        @JSONField(name = "abandon_ratio")
        private Integer abandonRatio;
        
        /**
         * Target tag expression for message notifications
         */
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;
        
        /**
         * Priority of messages sent through CDN channel (0-3)
         */
        @JSONField(name = "chat_msg_priority")
        private Integer chatMsgPriority;
        
        /**
         * Behavior for high-priority messages exceeding rate limit
         * 0: Downgrade to normal message (default), 1: Return 403 error
         */
        @JSONField(name = "forbidden_if_high_priority_msg_freq")
        private Integer forbiddenIfHighPriorityMsgFreq;
        
        /**
         * Default constructor
         */
        public MessageConfig() {
        }
        
        // Getters and Setters
        
        public Boolean getIgnoreChatBanned() {
            return ignoreChatBanned;
        }
        
        public void setIgnoreChatBanned(Boolean ignoreChatBanned) {
            this.ignoreChatBanned = ignoreChatBanned;
        }
        
        public Boolean getHistoryEnabled() {
            return historyEnabled;
        }
        
        public void setHistoryEnabled(Boolean historyEnabled) {
            this.historyEnabled = historyEnabled;
        }
        
        public Boolean getHighPriority() {
            return highPriority;
        }
        
        public void setHighPriority(Boolean highPriority) {
            this.highPriority = highPriority;
        }
        
        public Boolean getNeedHighPriorityMsgResend() {
            return needHighPriorityMsgResend;
        }
        
        public void setNeedHighPriorityMsgResend(Boolean needHighPriorityMsgResend) {
            this.needHighPriorityMsgResend = needHighPriorityMsgResend;
        }
        
        public Integer getAbandonRatio() {
            return abandonRatio;
        }
        
        public void setAbandonRatio(Integer abandonRatio) {
            this.abandonRatio = abandonRatio;
        }
        
        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }
        
        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
        
        public Integer getChatMsgPriority() {
            return chatMsgPriority;
        }
        
        public void setChatMsgPriority(Integer chatMsgPriority) {
            this.chatMsgPriority = chatMsgPriority;
        }
        
        public Integer getForbiddenIfHighPriorityMsgFreq() {
            return forbiddenIfHighPriorityMsgFreq;
        }
        
        public void setForbiddenIfHighPriorityMsgFreq(Integer forbiddenIfHighPriorityMsgFreq) {
            this.forbiddenIfHighPriorityMsgFreq = forbiddenIfHighPriorityMsgFreq;
        }
    }
    
    /**
     * Route configuration class for message forwarding
     */
    public static class RouteConfig {
        
        /**
         * Whether to forward messages to the application server
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;
        
        /**
         * Name of the environment for message forwarding
         */
        @JSONField(name = "route_environment")
        private String routeEnvironment;
        
        /**
         * Default constructor
         */
        public RouteConfig() {
        }
        
        // Getters and Setters
        
        public Boolean getRouteEnabled() {
            return routeEnabled;
        }
        
        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }
        
        public String getRouteEnvironment() {
            return routeEnvironment;
        }
        
        public void setRouteEnvironment(String routeEnvironment) {
            this.routeEnvironment = routeEnvironment;
        }
    }
    
    /**
     * Anti-spam configuration class
     */
    public static class AntispamConfig {
        
        /**
         * Whether to check the message through anti-spam service
         */
        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;
        
        /**
         * Anti-spam business ID for specific detection strategy
         */
        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;
        
        /**
         * Extended parameters for anti-spam service
         */
        @JSONField(name = "antispam_extension")
        private String antispamExtension;
        
        /**
         * Anti-cheat detection parameters
         */
        @JSONField(name = "antispam_cheating")
        private String antispamCheating;
        
        /**
         * Whether to check custom messages through anti-spam service
         */
        @JSONField(name = "antispam_custom_message_enabled")
        private Boolean antispamCustomMessageEnabled;
        
        /**
         * Custom content for anti-spam checking
         */
        @JSONField(name = "antispam_custom_message")
        private String antispamCustomMessage;
        
        /**
         * Default constructor
         */
        public AntispamConfig() {
        }
        
        // Getters and Setters
        
        public Boolean getAntispamEnabled() {
            return antispamEnabled;
        }
        
        public void setAntispamEnabled(Boolean antispamEnabled) {
            this.antispamEnabled = antispamEnabled;
        }
        
        public String getAntispamBusinessId() {
            return antispamBusinessId;
        }
        
        public void setAntispamBusinessId(String antispamBusinessId) {
            this.antispamBusinessId = antispamBusinessId;
        }
        
        public String getAntispamExtension() {
            return antispamExtension;
        }
        
        public void setAntispamExtension(String antispamExtension) {
            this.antispamExtension = antispamExtension;
        }
        
        public String getAntispamCheating() {
            return antispamCheating;
        }
        
        public void setAntispamCheating(String antispamCheating) {
            this.antispamCheating = antispamCheating;
        }
        
        public Boolean getAntispamCustomMessageEnabled() {
            return antispamCustomMessageEnabled;
        }
        
        public void setAntispamCustomMessageEnabled(Boolean antispamCustomMessageEnabled) {
            this.antispamCustomMessageEnabled = antispamCustomMessageEnabled;
        }
        
        public String getAntispamCustomMessage() {
            return antispamCustomMessage;
        }
        
        public void setAntispamCustomMessage(String antispamCustomMessage) {
            this.antispamCustomMessage = antispamCustomMessage;
        }
    }
    
    /**
     * AI parameters class for digital human functionality
     */
    public static class AiParams {
        
        /**
         * Digital human account ID
         */
        @JSONField(name = "account")
        private String account;
        
        /**
         * Content for the digital human query
         */
        @JSONField(name = "content")
        private Object content;
        
        /**
         * Message history for context
         */
        @JSONField(name = "messages")
        private List<Map<String, Object>> messages;
        
        /**
         * Variables to fill in prompt templates
         */
        @JSONField(name = "prompt_variables")
        private Object promptVariables;
        
        /**
         * Model configuration parameters
         */
        @JSONField(name = "config")
        private Object config;
        
        /**
         * Whether to send the original message to the chatroom
         */
        @JSONField(name = "send_original")
        private String sendOriginal;
        
        /**
         * Default constructor
         */
        public AiParams() {
        }
        
        // Getters and Setters
        
        public String getAccount() {
            return account;
        }
        
        public void setAccount(String account) {
            this.account = account;
        }
        
        public Object getContent() {
            return content;
        }
        
        public void setContent(Object content) {
            this.content = content;
        }
        
        public List<Map<String, Object>> getMessages() {
            return messages;
        }
        
        public void setMessages(List<Map<String, Object>> messages) {
            this.messages = messages;
        }
        
        public Object getPromptVariables() {
            return promptVariables;
        }
        
        public void setPromptVariables(Object promptVariables) {
            this.promptVariables = promptVariables;
        }
        
        public Object getConfig() {
            return config;
        }
        
        public void setConfig(Object config) {
            this.config = config;
        }
        
        public String getSendOriginal() {
            return sendOriginal;
        }
        
        public void setSendOriginal(String sendOriginal) {
            this.sendOriginal = sendOriginal;
        }
    }
} 