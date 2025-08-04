package com.netease.nim.server.sdk.im.v2.chatroom_message.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;
import java.util.Map;


public class SendChatroomMessageRequestV2 {
    

    @JSONField(serialize = false)  // Not serialized to JSON as it's used in URL path
    private Long roomId;
    

    @JSONField(name = "sender_id")
    private String senderId;
    

    @JSONField(name = "receiver_ids")
    private List<String> receiverIds;
    

    @JSONField(name = "resend_flag")
    private Integer resendFlag;
    

    @JSONField(name = "extension")
    private String extension;
    

    @JSONField(name = "message")
    private MessageBody message;
    

    @JSONField(name = "message_config")
    private MessageConfig messageConfig;
    

    @JSONField(name = "route_config")
    private RouteConfig routeConfig;
    

    @JSONField(name = "antispam_config")
    private AntispamConfig antispamConfig;
    

    @JSONField(name = "ai_params")
    private AiParams aiParams;
    

    public SendChatroomMessageRequestV2() {
    }
    

    public SendChatroomMessageRequestV2(String senderId, MessageBody message) {
        this.senderId = senderId;
        this.message = message;
    }
    

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
    

    public static class MessageBody {
        

        @JSONField(name = "message_client_id")
        private String messageClientId;
        

        @JSONField(name = "message_type")
        private Integer messageType;
        

        @JSONField(name = "sub_type")
        private Integer subType;
        

        @JSONField(name = "text")
        private String text;
        

        @JSONField(name = "attachment")
        private Map<?, ?> attachment;
        

        @JSONField(name = "location_x")
        private Double locationX;
        

        @JSONField(name = "location_y")
        private Double locationY;
        

        @JSONField(name = "location_z")
        private Double locationZ;
        

        public MessageBody() {
        }
        

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
        
        public Map<?, ?> getAttachment() {
            return attachment;
        }
        
        public void setAttachment(Map<?, ?> attachment) {
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
    

    public static class MessageConfig {
        

        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;
        

        @JSONField(name = "history_enabled")
        private Boolean historyEnabled;
        

        @JSONField(name = "high_priority")
        private Boolean highPriority;
        

        @JSONField(name = "need_high_priority_msg_resend")
        private Boolean needHighPriorityMsgResend;
        

        @JSONField(name = "abandon_ratio")
        private Integer abandonRatio;
        

        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;
        

        @JSONField(name = "chat_msg_priority")
        private Integer chatMsgPriority;
        

        @JSONField(name = "forbidden_if_high_priority_msg_freq")
        private Integer forbiddenIfHighPriorityMsgFreq;
        

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
    

    public static class RouteConfig {
        

        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;
        

        @JSONField(name = "route_environment")
        private String routeEnvironment;
        

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
    

    public static class AntispamConfig {
        

        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;
        

        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;
        

        @JSONField(name = "antispam_extension")
        private String antispamExtension;
        

        @JSONField(name = "antispam_cheating")
        private String antispamCheating;
        

        @JSONField(name = "antispam_custom_message_enabled")
        private Boolean antispamCustomMessageEnabled;
        

        @JSONField(name = "antispam_custom_message")
        private String antispamCustomMessage;
        

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
    

    public static class AiParams {
        


        @JSONField(name = "account")
        private String account;
        

        @JSONField(name = "content")
        private String content;
        

        @JSONField(name = "messages")
        private String messages;
        

        @JSONField(name = "prompt_variables")
        private String promptVariables;
        

        @JSONField(name = "config")
        private String config;
        

        @JSONField(name = "send_original")
        private Boolean sendOriginal;
        

        public AiParams() {
        }
        
        // Getters and Setters

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMessages() {
            return messages;
        }

        public void setMessages(String messages) {
            this.messages = messages;
        }

        public String getPromptVariables() {
            return promptVariables;
        }

        public void setPromptVariables(String promptVariables) {
            this.promptVariables = promptVariables;
        }

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }

        public Boolean getSendOriginal() {
            return sendOriginal;
        }

        public void setSendOriginal(Boolean sendOriginal) {
            this.sendOriginal = sendOriginal;
        }
    }
} 