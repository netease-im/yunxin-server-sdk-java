package com.netease.nim.server.sdk.im.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Map;

/**
 * Request class for sending a broadcast notification to a chatroom.
 */
public class SendChatroomBroadcastNotificationRequestV2 {

    /**
     * Client-generated unique identifier for the broadcast.
     */
    @JSONField(name = "client_broadcast_id")
    private String clientBroadcastId;

    /**
     * The account ID of the sender.
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * Custom extension field.
     */
    @JSONField(name = "extension")
    private String extension;

    /**
     * Resend flag (0 for no, 1 for yes). Default is 0.
     */
    @JSONField(name = "resend_flag")
    private Integer resendFlag;

    /**
     * The message content to be broadcast.
     */
    @JSONField(name = "message")
    private Message message;

    /**
     * Configuration for the message.
     */
    @JSONField(name = "message_config")
    private MessageConfig messageConfig;

    /**
     * Routing configuration.
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * Anti-spam configuration.
     */
    @JSONField(name = "antispam_config")
    private AntispamConfig antispamConfig;

    public SendChatroomBroadcastNotificationRequestV2() {
        this.resendFlag = 0;
    }

    public SendChatroomBroadcastNotificationRequestV2(String clientBroadcastId, String senderId, Message message) {
        this.clientBroadcastId = clientBroadcastId;
        this.senderId = senderId;
        this.message = message;
        this.resendFlag = 0;
    }

    public String getClientBroadcastId() {
        return clientBroadcastId;
    }

    public void setClientBroadcastId(String clientBroadcastId) {
        this.clientBroadcastId = clientBroadcastId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getResendFlag() {
        return resendFlag;
    }

    public void setResendFlag(Integer resendFlag) {
        this.resendFlag = resendFlag;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
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

    /**
     * Represents the message content of the broadcast.
     */
    public static class Message {

        /**
         * The type of the message (e.g., 0 for text, 1 for image, 100 for custom).
         */
        @JSONField(name = "message_type")
        private Integer messageType;

        /**
         * Custom message subtype.
         */
        @JSONField(name = "sub_type")
        private Integer subType;

        /**
         * The text content of the message.
         */
        @JSONField(name = "text")
        private String text;

        /**
         * The message attachment, for complex message types.
         */
        @JSONField(name = "attachment")
        private Map<?, ?> attachment;

        public Message() {
        }

        public Message(Integer messageType) {
            this.messageType = messageType;
        }

        public Message(Integer messageType, String text) {
            this.messageType = messageType;
            this.text = text;
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
    }

    /**
     * Configuration settings for the broadcast message.
     */
    public static class MessageConfig {

        /**
         * Whether the message is high priority.
         */
        @JSONField(name = "high_priority")
        private Boolean highPriority;

        /**
         * Tags for targeted notification.
         */
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;

        public Boolean getHighPriority() {
            return highPriority;
        }

        public void setHighPriority(Boolean highPriority) {
            this.highPriority = highPriority;
        }

        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }

        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
    }

    /**
     * Configuration for routing the broadcast.
     */
    public static class RouteConfig {

        /**
         * Whether routing is enabled.
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

        /**
         * The routing environment.
         */
        @JSONField(name = "route_environment")
        private String routeEnvironment;

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
     * Configuration for anti-spam checking.
     */
    public static class AntispamConfig {

        /**
         * Whether anti-spam is enabled.
         */
        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;

        /**
         * The business ID for anti-spam.
         */
        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;

        /**
         * Custom extension for anti-spam.
         */
        @JSONField(name = "antispam_extension")
        private String antispamExtension;

        /**
         * Anti-spam field for cheating detection.
         */
        @JSONField(name = "antispam_cheating")
        private String antispamCheating;

        /**
         * Whether to use a custom message for anti-spam results.
         */
        @JSONField(name = "antispam_custom_message_enabled")
        private Boolean antispamCustomMessageEnabled;

        /**
         * The custom message to use for anti-spam results.
         */
        @JSONField(name = "antispam_custom_message")
        private String antispamCustomMessage;

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
} 