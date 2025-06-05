package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request object for batch sending P2P messages
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations/messages
 */
public class BatchSendP2PMessageRequestV2 {

    /**
     * Sender's account ID (required)
     */
    @JSONField(name = "sender_id")
    private String senderId;

    /**
     * List of receiver account IDs (required, max 100)
     */
    @JSONField(name = "receiver_ids")
    private List<String> receiverIds;

    /**
     * Message content (required)
     */
    @JSONField(name = "message")
    private Message message;

    /**
     * Route configuration (optional)
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * Push configuration (optional)
     */
    @JSONField(name = "push_config")
    private PushConfig pushConfig;

    /**
     * Antispam configuration (optional)
     */
    @JSONField(name = "antispam_config")
    private AntispamConfig antispamConfig;

    /**
     * P2P message options (optional)
     */
    @JSONField(name = "p2p_option")
    private P2POption p2pOption;

    /**
     * Whether sender doesn't maintain message history (optional, default: false)
     */
    @JSONField(name = "sender_no_sense")
    private Boolean senderNoSense;

    /**
     * Whether receiver doesn't maintain message history (optional, default: false)
     */
    @JSONField(name = "receiver_no_sense")
    private Boolean receiverNoSense;

    /**
     * Developer extension field, JSON format (optional)
     */
    @JSONField(name = "extension")
    private String extension;

    /**
     * Whether to return message details in response (optional, default: false)
     */
    @JSONField(name = "need_message_detail")
    private Boolean needMessageDetail;

    /**
     * Message class containing the message content and type
     */
    public static class Message {
        /**
         * Message type (required)
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
         * Custom message subtype (optional, valid when message_type = 100)
         */
        @JSONField(name = "sub_type")
        private Integer subType;

        /**
         * Text content (required for text/tip messages, optional for others)
         * Max 5000 characters for text/tip messages
         * Max 500 characters for other message types (used for history search)
         */
        @JSONField(name = "text")
        private String text;

        /**
         * Message attachment or custom message content (required for non-text/tip messages)
         */
        @JSONField(name = "attachment")
        private Object attachment;

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
    }

    /**
     * Route configuration class
     */
    public static class RouteConfig {
        /**
         * Whether message should be routed to specified application server (default: true)
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

        /**
         * Environment name for message routing
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
     * Push configuration class
     */
    public static class PushConfig {
        /**
         * Whether message should trigger push notifications (default: true)
         */
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;

        /**
         * Whether push content should include nickname (default: true)
         */
        @JSONField(name = "push_nick_enabled")
        private Boolean pushNickEnabled;

        /**
         * Push content text (max 500 characters)
         */
        @JSONField(name = "push_content")
        private String pushContent;

        /**
         * Push payload (JSON format, max 2048 characters)
         */
        @JSONField(name = "push_payload")
        private String pushPayload;

        /**
         * Whether to force push to all devices
         */
        @JSONField(name = "push_forcepush_all")
        private Boolean pushForcepushAll;

        /**
         * List of device IDs to force push to
         */
        @JSONField(name = "push_forcepush_ids")
        private List<String> pushForcepushIds;

        /**
         * Force push content
         */
        @JSONField(name = "push_forcepush_content")
        private String pushForcepushContent;

        public Boolean getPushEnabled() {
            return pushEnabled;
        }

        public void setPushEnabled(Boolean pushEnabled) {
            this.pushEnabled = pushEnabled;
        }

        public Boolean getPushNickEnabled() {
            return pushNickEnabled;
        }

        public void setPushNickEnabled(Boolean pushNickEnabled) {
            this.pushNickEnabled = pushNickEnabled;
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

        public Boolean getPushForcepushAll() {
            return pushForcepushAll;
        }

        public void setPushForcepushAll(Boolean pushForcepushAll) {
            this.pushForcepushAll = pushForcepushAll;
        }

        public List<String> getPushForcepushIds() {
            return pushForcepushIds;
        }

        public void setPushForcepushIds(List<String> pushForcepushIds) {
            this.pushForcepushIds = pushForcepushIds;
        }

        public String getPushForcepushContent() {
            return pushForcepushContent;
        }

        public void setPushForcepushContent(String pushForcepushContent) {
            this.pushForcepushContent = pushForcepushContent;
        }
    }

    /**
     * Antispam configuration class
     */
    public static class AntispamConfig {
        /**
         * Whether to enable antispam (default: true)
         */
        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;

        /**
         * Antispam business ID
         */
        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;

        /**
         * Antispam extension data
         */
        @JSONField(name = "antispam_extension")
        private String antispamExtension;

        /**
         * Antispam cheating data
         */
        @JSONField(name = "antispam_cheating")
        private String antispamCheating;

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
    }

    /**
     * P2P message options class
     */
    public static class P2POption {
        /**
         * Whether to check if sender and receiver are friends (default: false)
         */
        @JSONField(name = "check_friend")
        private Boolean checkFriend;

        public Boolean getCheckFriend() {
            return checkFriend;
        }

        public void setCheckFriend(Boolean checkFriend) {
            this.checkFriend = checkFriend;
        }
    }

    // Getters and setters

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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }

    public PushConfig getPushConfig() {
        return pushConfig;
    }

    public void setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
    }

    public AntispamConfig getAntispamConfig() {
        return antispamConfig;
    }

    public void setAntispamConfig(AntispamConfig antispamConfig) {
        this.antispamConfig = antispamConfig;
    }

    public P2POption getP2pOption() {
        return p2pOption;
    }

    public void setP2pOption(P2POption p2pOption) {
        this.p2pOption = p2pOption;
    }

    public Boolean getSenderNoSense() {
        return senderNoSense;
    }

    public void setSenderNoSense(Boolean senderNoSense) {
        this.senderNoSense = senderNoSense;
    }

    public Boolean getReceiverNoSense() {
        return receiverNoSense;
    }

    public void setReceiverNoSense(Boolean receiverNoSense) {
        this.receiverNoSense = receiverNoSense;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Boolean getNeedMessageDetail() {
        return needMessageDetail;
    }

    public void setNeedMessageDetail(Boolean needMessageDetail) {
        this.needMessageDetail = needMessageDetail;
    }
} 