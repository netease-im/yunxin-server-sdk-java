package com.netease.nim.im.server.sdk.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Request object for sending a message
 * 
 * API: POST https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages
 */
public class SendMessageRequestV2 {

    /**
     * Conversation ID
     * Format examples:
     * - P2P chat: Accid1|1|Accid2
     * - Advanced group: Accid1|2|tid
     * - Super group: Accid1|3|tid
     */
    @JSONField(name = "conversation_id")
    private String conversationId;

    /**
     * Message content
     */
    @JSONField(name = "message")
    private MessageBody message;

    /**
     * Message configuration
     */
    @JSONField(name = "message_config")
    private MessageConfig messageConfig;

    /**
     * Target message configuration for group directed messages
     */
    @JSONField(name = "target_option")
    private TargetOption targetOption;

    /**
     * Message routing configuration
     */
    @JSONField(name = "route_config")
    private RouteConfig routeConfig;

    /**
     * Push notification configuration
     */
    @JSONField(name = "push_config")
    private PushConfig pushConfig;

    /**
     * Anti-spam configuration
     */
    @JSONField(name = "antispam_config")
    private AntispamConfig antispamConfig;

    /**
     * P2P message configuration
     */
    @JSONField(name = "p2p_option")
    private P2POption p2pOption;

    /**
     * Advanced team message configuration
     */
    @JSONField(name = "team_option")
    private TeamOption teamOption;

    /**
     * Super team message configuration
     */
    @JSONField(name = "superteam_option")
    private SuperTeamOption superteamOption;

    /**
     * Robot configuration
     */
    @JSONField(name = "robot_config")
    private RobotConfig robotConfig;

    /**
     * Thread message configuration
     */
    @JSONField(name = "thread_config")
    private ThreadConfig threadConfig;

    /**
     * Whether sender is unaware of message
     */
    @JSONField(name = "sender_no_sense")
    private Boolean senderNoSense;

    /**
     * Whether receiver is unaware of message
     */
    @JSONField(name = "receiver_no_sense")
    private Boolean receiverNoSense;

    /**
     * Extension information, JSON format
     */
    @JSONField(name = "extension")
    private String extension;

    // Inner classes for nested objects

    /**
     * Message body
     */
    public static class MessageBody {
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
         * Custom message subtype, only valid when messageType = 100
         */
        @JSONField(name = "sub_type")
        private Integer subType;

        /**
         * Message text content
         * For text messages and tip messages, this field is required
         * For other message types, this field is optional and can be used for full-text search
         */
        @JSONField(name = "text")
        private String text;

        /**
         * Message attachment
         * Required for non-text/tip messages
         */
        @JSONField(name = "attachment")
        private Object attachment;

        /**
         * Client message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;

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

        public String getMessageClientId() {
            return messageClientId;
        }

        public void setMessageClientId(String messageClientId) {
            this.messageClientId = messageClientId;
        }
    }

    /**
     * Message configuration
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
     * Target option for group directed messages
     */
    public static class TargetOption {
        /**
         * List of accounts who should receive the message
         */
        @JSONField(name = "receiver_account_ids")
        private List<String> receiverAccountIds;

        /**
         * Whether the receiver_account_ids is an inclusion list or exclusion list
         * true: inclusion list - only accounts in the list can see the message
         * false: exclusion list - accounts in the list cannot see the message
         */
        @JSONField(name = "inclusive")
        private Boolean inclusive;

        /**
         * Whether to check if accounts in the list are valid team members
         */
        @JSONField(name = "check_team_member_valid")
        private Boolean checkTeamMemberValid;

        /**
         * Whether new team members can see this message
         */
        @JSONField(name = "visible_to_new_member")
        private Boolean visibleToNewMember;

        public List<String> getReceiverAccountIds() {
            return receiverAccountIds;
        }

        public void setReceiverAccountIds(List<String> receiverAccountIds) {
            this.receiverAccountIds = receiverAccountIds;
        }

        public Boolean getInclusive() {
            return inclusive;
        }

        public void setInclusive(Boolean inclusive) {
            this.inclusive = inclusive;
        }

        public Boolean getCheckTeamMemberValid() {
            return checkTeamMemberValid;
        }

        public void setCheckTeamMemberValid(Boolean checkTeamMemberValid) {
            this.checkTeamMemberValid = checkTeamMemberValid;
        }

        public Boolean getVisibleToNewMember() {
            return visibleToNewMember;
        }

        public void setVisibleToNewMember(Boolean visibleToNewMember) {
            this.visibleToNewMember = visibleToNewMember;
        }
    }

    /**
     * Route configuration
     */
    public static class RouteConfig {
        /**
         * Whether the message is forwarded to specified application server
         */
        @JSONField(name = "route_enabled")
        private Boolean routeEnabled;

        /**
         * Environment name for routing
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
     * Push notification configuration
     */
    public static class PushConfig {
        /**
         * Whether push notification is enabled
         */
        @JSONField(name = "push_enabled")
        private Boolean pushEnabled;

        /**
         * Whether push content includes sender nickname
         */
        @JSONField(name = "push_nick_enabled")
        private Boolean pushNickEnabled;

        /**
         * Custom push content
         */
        @JSONField(name = "push_content")
        private String pushContent;

        /**
         * Custom push payload, JSON format
         */
        @JSONField(name = "push_payload")
        private String pushPayload;

        /**
         * Whether to force push to all team members (@ all)
         */
        @JSONField(name = "push_forcepush_all")
        private Boolean pushForcepushAll;

        /**
         * List of accounts to force push (@ specific users)
         */
        @JSONField(name = "push_forcepush_ids")
        private List<String> pushForcepushIds;

        /**
         * Custom content for force push
         */
        @JSONField(name = "push_forcepush_content")
        private String pushForcepushContent;
        
        /**
         * Whether to enable force push (@ operation)
         */
        @JSONField(name = "push_forcepush_enable")
        private Boolean pushForcepushEnable;

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
        
        public Boolean getPushForcepushEnable() {
            return pushForcepushEnable;
        }

        public void setPushForcepushEnable(Boolean pushForcepushEnable) {
            this.pushForcepushEnable = pushForcepushEnable;
        }
    }

    /**
     * Anti-spam configuration
     */
    public static class AntispamConfig {
        /**
         * Whether anti-spam is enabled
         */
        @JSONField(name = "antispam_enabled")
        private Boolean antispamEnabled;

        /**
         * Anti-spam business ID
         */
        @JSONField(name = "antispam_business_id")
        private String antispamBusinessId;

        /**
         * Anti-spam extension parameters
         */
        @JSONField(name = "antispam_extension")
        private String antispamExtension;

        /**
         * Anti-spam cheating parameters
         */
        @JSONField(name = "antispam_cheating")
        private String antispamCheating;

        /**
         * Whether to scan custom message
         */
        @JSONField(name = "antispam_custom_message_enabled")
        private Boolean antispamCustomMessageEnabled;

        /**
         * Custom message content to be scanned
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
     * P2P message configuration
     */
    public static class P2POption {
        /**
         * Whether to check if the receiver is a friend of the sender
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
     * Advanced team message configuration
     */
    public static class TeamOption {
        /**
         * Whether to enable read receipts
         */
        @JSONField(name = "mark_as_read")
        private Boolean markAsRead;

        /**
         * Whether to ignore team chat ban
         */
        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;

        /**
         * Whether to ignore member chat ban
         */
        @JSONField(name = "ignore_member_chat_banned")
        private Boolean ignoreMemberChatBanned;

        /**
         * Whether to check if sender is a valid team member
         */
        @JSONField(name = "check_team_member_valid")
        private Boolean checkTeamMemberValid;

        public Boolean getMarkAsRead() {
            return markAsRead;
        }

        public void setMarkAsRead(Boolean markAsRead) {
            this.markAsRead = markAsRead;
        }

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
     * Super team message configuration
     */
    public static class SuperTeamOption {
        /**
         * Whether to ignore team chat ban
         */
        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;

        /**
         * Whether to ignore member chat ban
         */
        @JSONField(name = "ignore_member_chat_banned")
        private Boolean ignoreMemberChatBanned;

        /**
         * Whether to check if sender is a valid team member
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
     * Robot configuration
     */
    public static class RobotConfig {
        /**
         * Robot account ID
         */
        @JSONField(name = "robot_account_id")
        private String robotAccountId;

        /**
         * Robot message topic
         */
        @JSONField(name = "robot_topic")
        private String robotTopic;

        /**
         * Robot function
         */
        @JSONField(name = "robot_function")
        private String robotFunction;

        /**
         * Robot custom content
         */
        @JSONField(name = "robot_custom_content")
        private String robotCustomContent;

        public String getRobotAccountId() {
            return robotAccountId;
        }

        public void setRobotAccountId(String robotAccountId) {
            this.robotAccountId = robotAccountId;
        }

        public String getRobotTopic() {
            return robotTopic;
        }

        public void setRobotTopic(String robotTopic) {
            this.robotTopic = robotTopic;
        }

        public String getRobotFunction() {
            return robotFunction;
        }

        public void setRobotFunction(String robotFunction) {
            this.robotFunction = robotFunction;
        }

        public String getRobotCustomContent() {
            return robotCustomContent;
        }

        public void setRobotCustomContent(String robotCustomContent) {
            this.robotCustomContent = robotCustomContent;
        }
    }

    /**
     * Thread message configuration
     */
    public static class ThreadConfig {
        /**
         * Thread root message information
         */
        @JSONField(name = "thread_root")
        private ThreadMessage threadRoot;

        /**
         * Reply message information
         */
        @JSONField(name = "thread_reply")
        private ThreadMessage threadReply;

        public ThreadMessage getThreadRoot() {
            return threadRoot;
        }

        public void setThreadRoot(ThreadMessage threadRoot) {
            this.threadRoot = threadRoot;
        }

        public ThreadMessage getThreadReply() {
            return threadReply;
        }

        public void setThreadReply(ThreadMessage threadReply) {
            this.threadReply = threadReply;
        }
    }

    /**
     * Thread message information
     */
    public static class ThreadMessage {
        /**
         * Sender ID
         */
        @JSONField(name = "sender_id")
        private String senderId;

        /**
         * Receiver ID
         */
        @JSONField(name = "receiver_id")
        private String receiverId;

        /**
         * Message creation time
         */
        @JSONField(name = "create_time")
        private Long createTime;

        /**
         * Server message ID
         */
        @JSONField(name = "message_server_id")
        private Long messageServerId;

        /**
         * Client message ID
         */
        @JSONField(name = "message_client_id")
        private String messageClientId;

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

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
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
    }

    /**
     * Helper method to create a text message request
     * 
     * @param conversationId The conversation ID
     * @param text The message text
     * @return A request object configured for sending a text message
     */
    public static SendMessageRequestV2 createTextMessage(String conversationId, String text) {
        SendMessageRequestV2 request = new SendMessageRequestV2();
        request.setConversationId(conversationId);
        
        MessageBody message = new MessageBody();
        message.setMessageType(0); // Text message
        message.setText(text);
        
        request.setMessage(message);
        return request;
    }
    
    /**
     * Helper method to create a custom message request
     * 
     * @param conversationId The conversation ID
     * @param attachment The custom message attachment object
     * @param subType The custom message subtype (optional)
     * @return A request object configured for sending a custom message
     */
    public static SendMessageRequestV2 createCustomMessage(String conversationId, Object attachment, Integer subType) {
        SendMessageRequestV2 request = new SendMessageRequestV2();
        request.setConversationId(conversationId);
        
        MessageBody message = new MessageBody();
        message.setMessageType(100); // Custom message
        message.setAttachment(attachment);
        
        if (subType != null) {
            message.setSubType(subType);
        }
        
        request.setMessage(message);
        return request;
    }

    // Getters and Setters
    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
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

    public TargetOption getTargetOption() {
        return targetOption;
    }

    public void setTargetOption(TargetOption targetOption) {
        this.targetOption = targetOption;
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

    public SuperTeamOption getSuperteamOption() {
        return superteamOption;
    }

    public void setSuperteamOption(SuperTeamOption superteamOption) {
        this.superteamOption = superteamOption;
    }

    public RobotConfig getRobotConfig() {
        return robotConfig;
    }

    public void setRobotConfig(RobotConfig robotConfig) {
        this.robotConfig = robotConfig;
    }

    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
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
} 