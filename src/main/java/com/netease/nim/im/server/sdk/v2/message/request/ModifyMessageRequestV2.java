package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request object for modifying (updating) a message
 * 
 * API: POST https://open.yunxinapi.com/im/v2/messages/actions/modifyMsg
 */
public class ModifyMessageRequestV2 {

    /**
     * The ID of the account operating the message modification (required)
     */
    @JSONField(name = "operator")
    private String operator;

    /**
     * Original conversation type (required)
     * 1: P2P chat
     * 2: Advanced team
     * 3: Super team
     */
    @JSONField(name = "type")
    private Integer type;

    /**
     * Developer extension field, JSON format (optional)
     */
    @JSONField(name = "extension")
    private String extension;

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
     * Team message options (optional)
     */
    @JSONField(name = "team_option")
    private TeamOption teamOption;

    /**
     * Super team message options (optional)
     */
    @JSONField(name = "superteam_option")
    private SuperTeamOption superTeamOption;

    /**
     * Message class containing details of the message to be modified
     */
    public static class Message {
        /**
         * Server message ID of the original message (required)
         */
        @JSONField(name = "message_server_id")
        private Long messageServerId;

        /**
         * Original receiver ID or team ID (required)
         */
        @JSONField(name = "receiver_id")
        private String receiverId;

        /**
         * Original message sending time (required)
         */
        @JSONField(name = "time")
        private Long time;

        /**
         * Original sender ID (required)
         */
        @JSONField(name = "sender_id")
        private String senderId;

        /**
         * Original message type (required)
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
         * Custom message subtype (optional)
         * Valid when message_type = 100
         */
        @JSONField(name = "sub_type")
        private Integer subType;

        /**
         * Text content (optional)
         * For text/tip messages: message content, max 5000 characters
         * For other message types: description text, max 500 characters
         */
        @JSONField(name = "text")
        private String text;

        /**
         * Message attachment or custom message content (optional)
         */
        @JSONField(name = "attachment")
        private Object attachment;

        // Getters and setters
        public Long getMessageServerId() {
            return messageServerId;
        }

        public void setMessageServerId(Long messageServerId) {
            this.messageServerId = messageServerId;
        }

        public String getReceiverId() {
            return receiverId;
        }

        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
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
    }

    /**
     * Message configuration class
     */
    public static class MessageConfig {
        /**
         * Whether to update this message to the last message of the conversation
         * Default: true
         */
        @JSONField(name = "conversation_update_enabled")
        private Boolean conversationUpdateEnabled;

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
         * Whether this message should be routed to the specified application server
         * Default: true
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
         * Whether this message should trigger push notifications
         * Default: true
         */
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;

        /**
         * Whether push content should include nickname
         * Default: true
         */
        @JSONField(name = "push_nick_enabled")
        private Boolean pushNickEnabled;

        /**
         * Push content text
         * Max 500 characters
         */
        @JSONField(name = "push_content")
        private String pushContent;

        /**
         * Push payload (JSON format)
         * Max 2048 characters
         */
        @JSONField(name = "push_payload")
        private String pushPayload;

        /**
         * Whether forced pushing is enabled (for @ function)
         * Default: false
         */
        @JSONField(name = "push_forcepush_enable")
        private Boolean pushForcepushEnable;

        /**
         * Whether to force push to all team members
         * Default: false
         */
        @JSONField(name = "push_forcepush_all")
        private Boolean pushForcepushAll;

        /**
         * List of account IDs to force push to
         * Max 100 accounts
         */
        @JSONField(name = "push_forcepush_ids")
        private List<String> pushForcepushIds;

        /**
         * Forced push content text
         * Max 500 characters
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

        public Boolean getPushForcepushEnable() {
            return pushForcepushEnable;
        }

        public void setPushForcepushEnable(Boolean pushForcepushEnable) {
            this.pushForcepushEnable = pushForcepushEnable;
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
         * Whether the message requires antispam checking
         * Default: true if antispam service is enabled
         */
        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;

        /**
         * Antispam business ID
         */
        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;

        /**
         * Antispam extension parameters
         * JSON format, max 1024 characters
         */
        @JSONField(name = "antispam_extension")
        private String antispamExtension;

        /**
         * Antispam anti-cheating parameters
         * JSON format, max 1024 characters
         */
        @JSONField(name = "antispam_cheating")
        private String antispamCheating;

        /**
         * Whether to apply antispam to custom message content
         * Default: false
         */
        @JSONField(name = "antispam_custom_message_enabled")
        private Boolean antispamCustomMessageEnabled;

        /**
         * Custom message content for antispam checking
         * JSON format
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

    /**
     * P2P message options class
     */
    public static class P2POption {
        /**
         * Whether this message should only be sent to friends
         * Default: false
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

    /**
     * Team message options class
     */
    public static class TeamOption {
        /**
         * Whether to ignore team chat ban when modifying messages
         * Default: false
         */
        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;

        /**
         * Whether to ignore member chat ban when modifying messages
         * Default: false
         */
        @JSONField(name = "ignore_member_chat_banned")
        private Boolean ignoreMemberChatBanned;

        /**
         * Whether to check team member validity
         * Default: true
         */
        @JSONField(name = "check_team_member_valid")
        private Boolean checkTeamMemberValid;

        public Boolean getIgnoreChatBanned() {
            return ignoreChatBanned;
        }

        public void setIgnoreChatBanned(Boolean ignoreChatBanned) {
            this.ignoreChatBanned = ignoreChatBanned;
        }

        public Boolean getIgnoreMemberChatBanned() {
            return ignoreMemberChatBanned;
        }

        public void setIgnoreMemberChatBanned(Boolean ignoreMemberChatBanned) {
            this.ignoreMemberChatBanned = ignoreMemberChatBanned;
        }

        public Boolean getCheckTeamMemberValid() {
            return checkTeamMemberValid;
        }

        public void setCheckTeamMemberValid(Boolean checkTeamMemberValid) {
            this.checkTeamMemberValid = checkTeamMemberValid;
        }
    }

    /**
     * Super team message options class
     */
    public static class SuperTeamOption {
        /**
         * Whether to ignore team chat ban when modifying messages
         * Default: false
         */
        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;

        /**
         * Whether to ignore member chat ban when modifying messages
         * Default: false
         */
        @JSONField(name = "ignore_member_chat_banned")
        private Boolean ignoreMemberChatBanned;

        /**
         * Whether to check team member validity
         * Default: true
         */
        @JSONField(name = "check_team_member_valid")
        private Boolean checkTeamMemberValid;

        public Boolean getIgnoreChatBanned() {
            return ignoreChatBanned;
        }

        public void setIgnoreChatBanned(Boolean ignoreChatBanned) {
            this.ignoreChatBanned = ignoreChatBanned;
        }

        public Boolean getIgnoreMemberChatBanned() {
            return ignoreMemberChatBanned;
        }

        public void setIgnoreMemberChatBanned(Boolean ignoreMemberChatBanned) {
            this.ignoreMemberChatBanned = ignoreMemberChatBanned;
        }

        public Boolean getCheckTeamMemberValid() {
            return checkTeamMemberValid;
        }

        public void setCheckTeamMemberValid(Boolean checkTeamMemberValid) {
            this.checkTeamMemberValid = checkTeamMemberValid;
        }
    }

    // Getters and setters for main class
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public TeamOption getTeamOption() {
        return teamOption;
    }

    public void setTeamOption(TeamOption teamOption) {
        this.teamOption = teamOption;
    }

    public SuperTeamOption getSuperTeamOption() {
        return superTeamOption;
    }

    public void setSuperTeamOption(SuperTeamOption superTeamOption) {
        this.superTeamOption = superTeamOption;
    }
} 