package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;
import java.util.Map;

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
     * Message configuration (optional)
     */
    @JSONField(name = "message_config")
    private MessageConfig messageConfig;

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
        private Map<?, ?> attachment;

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
     * Message configuration class
     */
    public static class MessageConfig {
        /**
         * Whether the message is counted in unread count
         */
        @JSONField(name = "unread_enabled")
        private Boolean unreadEnabled;

        /**
         * Whether the message is synchronized across sender's multi-devices
         */
        @JSONField(name = "mutil_sync_enabled")
        private Boolean mutilSyncEnabled;

        /**
         * Whether the message is stored as offline message
         */
        @JSONField(name = "offline_enabled")
        private Boolean offlineEnabled;

        /**
         * Whether the message is stored in cloud history
         */
        @JSONField(name = "history_enabled")
        private Boolean historyEnabled;

        /**
         * Whether the message needs roaming
         */
        @JSONField(name = "roaming_enabled")
        private Boolean roamingEnabled;

        /**
         * Whether the message updates the last message in conversation list
         */
        @JSONField(name = "conversation_update_enabled")
        private Boolean conversationUpdateEnabled;

        public Boolean getUnreadEnabled() {
            return unreadEnabled;
        }

        public void setUnreadEnabled(Boolean unreadEnabled) {
            this.unreadEnabled = unreadEnabled;
        }

        public Boolean getMutilSyncEnabled() {
            return mutilSyncEnabled;
        }

        public void setMutilSyncEnabled(Boolean mutilSyncEnabled) {
            this.mutilSyncEnabled = mutilSyncEnabled;
        }

        public Boolean getOfflineEnabled() {
            return offlineEnabled;
        }

        public void setOfflineEnabled(Boolean offlineEnabled) {
            this.offlineEnabled = offlineEnabled;
        }

        public Boolean getHistoryEnabled() {
            return historyEnabled;
        }

        public void setHistoryEnabled(Boolean historyEnabled) {
            this.historyEnabled = historyEnabled;
        }

        public Boolean getRoamingEnabled() {
            return roamingEnabled;
        }

        public void setRoamingEnabled(Boolean roamingEnabled) {
            this.roamingEnabled = roamingEnabled;
        }

        public Boolean getConversationUpdateEnabled() {
            return conversationUpdateEnabled;
        }

        public void setConversationUpdateEnabled(Boolean conversationUpdateEnabled) {
            this.conversationUpdateEnabled = conversationUpdateEnabled;
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