package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request object for sending a stream message.
 * API: POST https://{endpoint}/im/v2/conversations/{conversation_id}/messages/actions/stream_message
 */
public class StreamMessageRequestV2 {

    /**
     * Conversation ID.
     */
    private String conversationId;

    /**
     * Message body.
     */
    @JSONField(name = "message")
    private StreamMessage message;

    /**
     * Message configuration.
     */
    @JSONField(name = "message_config")
    private MessageConfig messageConfig;

    /**
     * Routing configuration.
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * P2P message options.
     */
    @JSONField(name = "p2p_option")
    private P2POption p2pOption;

    /**
     * Push notification configuration.
     */
    @JSONField(name = "push_config")
    private PushConfig pushConfig;

    /**
     * Developer extension field.
     */
    @JSONField(name = "extension")
    private String extension;

    public static class StreamMessage {
        @JSONField(name = "message_type")
        /**
         * Message type.
         * 0: Text message (default)
         */
        private Integer messageType;

        @JSONField(name = "message_client_id")
        private String messageClientId;

        @JSONField(name = "message_server_id")
        private Long messageServerId;

        @JSONField(name = "attachment")
        private StreamAttachment attachment;

        public Integer getMessageType() {
            return messageType;
        }

        public void setMessageType(Integer messageType) {
            this.messageType = messageType;
        }

        public String getMessageClientId() {
            return messageClientId;
        }

        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }

        public Long getMessageServerId() {
            return messageServerId;
        }

        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }

        public StreamAttachment getAttachment() {
            return attachment;
        }

        public void setAttachment(StreamAttachment attachment) {
            this.attachment = attachment;
        }
    }

    public static class StreamAttachment {
        /**
         * 流式消息的内容
         */
        @JSONField(name = "text")
        private String text;

        /**
         * 流式分片的序号，从 0 开始
         */
        @JSONField(name = "index")
        private Integer index;

        /**
         * 该流式输出是否已结束。0（默认）：未结束，1：结束
         */
        @JSONField(name = "finish")
        private Integer finish;

        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public Integer getIndex() {
            return index;
        }
        public void setIndex(Integer index) {
            this.index = index;
        }
        public Integer getFinish() {
            return finish;
        }
        public void setFinish(Integer finish) {
            this.finish = finish;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StreamAttachment that = (StreamAttachment) o;
            return java.util.Objects.equals(text, that.text)
                    && java.util.Objects.equals(index, that.index)
                    && java.util.Objects.equals(finish, that.finish);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(text, index, finish);
        }
    }

    public static class MessageConfig {
        @JSONField(name = "unread_enabled")
        private Boolean unreadEnabled;

        @JSONField(name = "mutil_sync_enabled")
        private Boolean mutilSyncEnabled;

        @JSONField(name = "history_enabled")
        private Boolean historyEnabled;

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

        public Boolean getHistoryEnabled() {
            return historyEnabled;
        }

        public void setHistoryEnabled(Boolean historyEnabled) {
            this.historyEnabled = historyEnabled;
        }

        public Boolean getConversationUpdateEnabled() {
            return conversationUpdateEnabled;
        }

        public void setConversationUpdateEnabled(Boolean conversationUpdateEnabled) {
            this.conversationUpdateEnabled = conversationUpdateEnabled;
        }
    }

    public static class RouteConfig {
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

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

    public static class P2POption {
        @JSONField(name = "check_friend")
        private Boolean checkFriend;

        public Boolean getCheckFriend() {
            return checkFriend;
        }

        public void setCheckFriend(Boolean checkFriend) {
            this.checkFriend = checkFriend;
        }
    }

    public static class PushConfig {
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;

        @JSONField(name = "push_nick_enabled")
        private Boolean pushNickEnabled;

        @JSONField(name = "push_content")
        private String pushContent;

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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public StreamMessage getMessage() {
        return message;
    }

    public void setMessage(StreamMessage message) {
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

    public P2POption getP2pOption() {
        return p2pOption;
    }

    public void setP2pOption(P2POption p2pOption) {
        this.p2pOption = p2pOption;
    }

    public PushConfig getPushConfig() {
        return pushConfig;
    }

    public void setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
