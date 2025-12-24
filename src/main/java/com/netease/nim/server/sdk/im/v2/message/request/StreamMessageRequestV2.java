package com.netease.nim.server.sdk.im.v2.message.request;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

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

    /**
     * RAG information list carried in stream message.
     */
    @JSONField(name = "rag_info_list")
    private List<RagInfo> ragInfoList;

    /**
     * Advanced team message configuration.
     */
    @JSONField(name = "team_option")
    private TeamOption teamOption;

    /**
     * Team targeted message configuration.
     */
    @JSONField(name = "target_option")
    private TargetOption targetOption;

    /**
     * Thread message configuration.
     */
    @JSONField(name = "thread_config")
    private ThreadConfig threadConfig;

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

    public java.util.List<RagInfo> getRagInfoList() {
        return ragInfoList;
    }

    public void setRagInfoList(java.util.List<RagInfo> ragInfoList) {
        this.ragInfoList = ragInfoList;
    }

    public TeamOption getTeamOption() {
        return teamOption;
    }

    public void setTeamOption(TeamOption teamOption) {
        this.teamOption = teamOption;
    }

    public TargetOption getTargetOption() {
        return targetOption;
    }

    public void setTargetOption(TargetOption targetOption) {
        this.targetOption = targetOption;
    }

    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }

    /**
     * RAG information for stream messages.
     */
    public static class RagInfo {
        @JSONField(name = "name")
        private String name;

        @JSONField(name = "icon")
        private String icon;

        @JSONField(name = "title")
        private String title;

        @JSONField(name = "time")
        private Long time;

        @JSONField(name = "url")
        private String url;

        @JSONField(name = "description")
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    /**
     * Advanced team message configuration.
     */
    public static class TeamOption {
        @JSONField(name = "mark_as_read")
        private Boolean markAsRead;

        @JSONField(name = "ignore_chat_banned")
        private Boolean ignoreChatBanned;

        @JSONField(name = "ignore_member_chat_banned")
        private Boolean ignoreMemberChatBanned;

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
     * Team targeted message configuration.
     */
    public static class TargetOption {
        @JSONField(name = "receiver_account_ids")
        private List<String> receiverAccountIds;

        @JSONField(name = "inclusive")
        private Boolean inclusive;

        @JSONField(name = "check_team_member_valid")
        private Boolean checkTeamMemberValid;

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
     * Thread message configuration.
     */
    public static class ThreadConfig {
        @JSONField(name = "thread_root")
        private ThreadMessage threadRoot;

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
     * Thread message information.
     */
    public static class ThreadMessage {
        @JSONField(name = "sender_id")
        private String senderId;

        @JSONField(name = "receiver_id")
        private String receiverId;

        @JSONField(name = "create_time")
        private Long createTime;

        @JSONField(name = "message_server_id")
        private Long messageServerId;

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
}
