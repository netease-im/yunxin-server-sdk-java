package com.netease.nim.server.sdk.im.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for sending broadcast notifications to all chatrooms
 * 
 * API: POST https://open.yunxinapi.com/im/v2/broadcast_notification/actions/chatroom
 */
public class SendChatroomBroadcastNotificationRequestV2 {

    /**
     * Required. Chatroom broadcast message ID. Used by clients for message deduplication.
     */
    @JSONField(name = "client_broadcast_id")
    private String clientBroadcastId;

    /**
     * Required. Yunxin account ID of the chatroom broadcast message sender.
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * Optional. Developer extension field, max length 4096 characters.
     */
    @JSONField(name = "extension")
    private String extension;

    /**
     * Optional. Whether this is a resend message.
     * 0: Not a resend message (default)
     * 1: Resend message (will check for duplicates using client_broadcast_id)
     */
    @JSONField(name = "resend_flag")
    private Integer resendFlag;

    /**
     * Required. Message body.
     */
    @JSONField(name = "message")
    private Message message;

    /**
     * Optional. Message configuration.
     */
    @JSONField(name = "message_config")
    private MessageConfig messageConfig;

    /**
     * Optional. Route configuration.
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * Optional. Antispam configuration.
     */
    @JSONField(name = "antispam_config")
    private AntispamConfig antispamConfig;

    /**
     * Default constructor
     */
    public SendChatroomBroadcastNotificationRequestV2() {
        // Initialize with default values
        this.resendFlag = 0;
    }

    /**
     * Constructor with required parameters
     *
     * @param clientBroadcastId Chatroom broadcast message ID
     * @param senderId Sender account ID
     * @param message Message body
     */
    public SendChatroomBroadcastNotificationRequestV2(String clientBroadcastId, String senderId, Message message) {
        this.clientBroadcastId = clientBroadcastId;
        this.senderId = senderId;
        this.message = message;
        this.resendFlag = 0;
    }

    /**
     * Get client broadcast ID
     *
     * @return Client broadcast ID
     */
    public String getClientBroadcastId() {
        return clientBroadcastId;
    }

    /**
     * Set client broadcast ID
     *
     * @param clientBroadcastId Client broadcast ID
     */
    public void setClientBroadcastId(String clientBroadcastId) {
        this.clientBroadcastId = clientBroadcastId;
    }

    /**
     * Get sender ID
     *
     * @return Sender account ID
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Set sender ID
     *
     * @param senderId Sender account ID
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
     * Get extension
     *
     * @return Extension field
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Set extension
     *
     * @param extension Extension field
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get resend flag
     *
     * @return Resend flag
     */
    public Integer getResendFlag() {
        return resendFlag;
    }

    /**
     * Set resend flag
     *
     * @param resendFlag Resend flag
     */
    public void setResendFlag(Integer resendFlag) {
        this.resendFlag = resendFlag;
    }

    /**
     * Get message body
     *
     * @return Message body
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Set message body
     *
     * @param message Message body
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * Get message configuration
     *
     * @return Message configuration
     */
    public MessageConfig getMessageConfig() {
        return messageConfig;
    }

    /**
     * Set message configuration
     *
     * @param messageConfig Message configuration
     */
    public void setMessageConfig(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }

    /**
     * Get route configuration
     *
     * @return Route configuration
     */
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    /**
     * Set route configuration
     *
     * @param routeConfig Route configuration
     */
    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }

    /**
     * Get antispam configuration
     *
     * @return Antispam configuration
     */
    public AntispamConfig getAntispamConfig() {
        return antispamConfig;
    }

    /**
     * Set antispam configuration
     *
     * @param antispamConfig Antispam configuration
     */
    public void setAntispamConfig(AntispamConfig antispamConfig) {
        this.antispamConfig = antispamConfig;
    }

    /**
     * Message body class
     */
    public static class Message {
        /**
         * Required. Message type.
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
         * Optional. Custom message subtype, greater than 0.
         * Only valid when message_type = 100.
         */
        @JSONField(name = "sub_type")
        private Integer subType;

        /**
         * Optional. For text and tip messages, this field is required and contains the message content.
         * For other message types, this field is optional and contains descriptive text.
         * Max length: 5000 characters for text/tip messages, 500 characters for other types.
         */
        @JSONField(name = "text")
        private String text;

        /**
         * Optional. Properties for non-text/tip messages or custom message content.
         * Required for non-text/tip messages. Max length: 5000 characters.
         */
        @JSONField(name = "attachment")
        private Object attachment;

        /**
         * Constructor with message type
         *
         * @param messageType Message type
         */
        public Message(Integer messageType) {
            this.messageType = messageType;
        }

        /**
         * Constructor with message type and text
         *
         * @param messageType Message type
         * @param text Message text
         */
        public Message(Integer messageType, String text) {
            this.messageType = messageType;
            this.text = text;
        }

        /**
         * Get message type
         *
         * @return Message type
         */
        public Integer getMessageType() {
            return messageType;
        }

        /**
         * Set message type
         *
         * @param messageType Message type
         */
        public void setMessageType(Integer messageType) {
            this.messageType = messageType;
        }

        /**
         * Get subtype
         *
         * @return Subtype
         */
        public Integer getSubType() {
            return subType;
        }

        /**
         * Set subtype
         *
         * @param subType Subtype
         */
        public void setSubType(Integer subType) {
            this.subType = subType;
        }

        /**
         * Get text
         *
         * @return Text
         */
        public String getText() {
            return text;
        }

        /**
         * Set text
         *
         * @param text Text
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * Get attachment
         *
         * @return Attachment
         */
        public Object getAttachment() {
            return attachment;
        }

        /**
         * Set attachment
         *
         * @param attachment Attachment
         */
        public void setAttachment(Object attachment) {
            this.attachment = attachment;
        }
    }

    /**
     * Message configuration class
     */
    public static class MessageConfig {
        /**
         * Optional. Whether this is a high priority message.
         * Default: false (low priority)
         */
        @JSONField(name = "high_priority")
        private Boolean highPriority;

        /**
         * Optional. Target tag expression for chatroom message delivery.
         * Max length: 128 characters.
         */
        @JSONField(name = "notify_target_tags")
        private String notifyTargetTags;

        /**
         * Get high priority flag
         *
         * @return High priority flag
         */
        public Boolean getHighPriority() {
            return highPriority;
        }

        /**
         * Set high priority flag
         *
         * @param highPriority High priority flag
         */
        public void setHighPriority(Boolean highPriority) {
            this.highPriority = highPriority;
        }

        /**
         * Get notify target tags
         *
         * @return Notify target tags
         */
        public String getNotifyTargetTags() {
            return notifyTargetTags;
        }

        /**
         * Set notify target tags
         *
         * @param notifyTargetTags Notify target tags
         */
        public void setNotifyTargetTags(String notifyTargetTags) {
            this.notifyTargetTags = notifyTargetTags;
        }
    }

    /**
     * Route configuration class
     */
    public static class RouteConfig {
        /**
         * Optional. Whether this message should be forwarded to the specified application server.
         * Default: true
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

        /**
         * Optional. Environment name for message forwarding.
         */
        @JSONField(name = "route_environment")
        private String routeEnvironment;

        /**
         * Get route enabled flag
         *
         * @return Route enabled flag
         */
        public Boolean getRouteEnabled() {
            return routeEnabled;
        }

        /**
         * Set route enabled flag
         *
         * @param routeEnabled Route enabled flag
         */
        public void setRouteEnabled(Boolean routeEnabled) {
            this.routeEnabled = routeEnabled;
        }

        /**
         * Get route environment
         *
         * @return Route environment
         */
        public String getRouteEnvironment() {
            return routeEnvironment;
        }

        /**
         * Set route environment
         *
         * @param routeEnvironment Route environment
         */
        public void setRouteEnvironment(String routeEnvironment) {
            this.routeEnvironment = routeEnvironment;
        }
    }

    /**
     * Antispam configuration class
     */
    public static class AntispamConfig {
        /**
         * Optional. Whether this message should be checked by antispam.
         * Default: true if antispam is enabled for the application.
         */
        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;

        /**
         * Optional. Antispam business ID.
         */
        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;

        /**
         * Optional. Antispam extension parameters.
         * Max length: 1024 characters.
         */
        @JSONField(name = "antispam_extension")
        private String antispamExtension;

        /**
         * Optional. Antispam cheating parameters.
         * Max length: 1024 characters.
         */
        @JSONField(name = "antispam_cheating")
        private String antispamCheating;

        /**
         * Optional. Whether to check custom message content.
         * Default: false
         */
        @JSONField(name = "antispam_custom_message_enabled")
        private Boolean antispamCustomMessageEnabled;

        /**
         * Optional. Custom content for antispam checking.
         * Max length: same as text parameter.
         */
        @JSONField(name = "antispam_custom_message")
        private String antispamCustomMessage;

        /**
         * Get antispam enabled flag
         *
         * @return Antispam enabled flag
         */
        public Boolean getAntispamEnabled() {
            return antispamEnabled;
        }

        /**
         * Set antispam enabled flag
         *
         * @param antispamEnabled Antispam enabled flag
         */
        public void setAntispamEnabled(Boolean antispamEnabled) {
            this.antispamEnabled = antispamEnabled;
        }

        /**
         * Get antispam business ID
         *
         * @return Antispam business ID
         */
        public String getAntispamBusinessId() {
            return antispamBusinessId;
        }

        /**
         * Set antispam business ID
         *
         * @param antispamBusinessId Antispam business ID
         */
        public void setAntispamBusinessId(String antispamBusinessId) {
            this.antispamBusinessId = antispamBusinessId;
        }

        /**
         * Get antispam extension
         *
         * @return Antispam extension
         */
        public String getAntispamExtension() {
            return antispamExtension;
        }

        /**
         * Set antispam extension
         *
         * @param antispamExtension Antispam extension
         */
        public void setAntispamExtension(String antispamExtension) {
            this.antispamExtension = antispamExtension;
        }

        /**
         * Get antispam cheating
         *
         * @return Antispam cheating
         */
        public String getAntispamCheating() {
            return antispamCheating;
        }

        /**
         * Set antispam cheating
         *
         * @param antispamCheating Antispam cheating
         */
        public void setAntispamCheating(String antispamCheating) {
            this.antispamCheating = antispamCheating;
        }

        /**
         * Get antispam custom message enabled flag
         *
         * @return Antispam custom message enabled flag
         */
        public Boolean getAntispamCustomMessageEnabled() {
            return antispamCustomMessageEnabled;
        }

        /**
         * Set antispam custom message enabled flag
         *
         * @param antispamCustomMessageEnabled Antispam custom message enabled flag
         */
        public void setAntispamCustomMessageEnabled(Boolean antispamCustomMessageEnabled) {
            this.antispamCustomMessageEnabled = antispamCustomMessageEnabled;
        }

        /**
         * Get antispam custom message
         *
         * @return Antispam custom message
         */
        public String getAntispamCustomMessage() {
            return antispamCustomMessage;
        }

        /**
         * Set antispam custom message
         *
         * @param antispamCustomMessage Antispam custom message
         */
        public void setAntispamCustomMessage(String antispamCustomMessage) {
            this.antispamCustomMessage = antispamCustomMessage;
        }
    }
} 