package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for toggling chat ban on chatroom members with a specific tag
 * 
 * This request is used to temporarily ban or unban chatroom members with a specific tag from chatting.
 */
public class ToggleTaggedMembersChatBanRequestV2 {
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Operator account ID (must be creator or administrator)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Target tag to apply the chat ban
     */
    @JSONField(name = "target_tag")
    private String targetTag;
    
    /**
     * Whether to set as banned or unbanned
     * true: ban from chatting
     * false: remove ban from chatting
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Duration of the temporary chat ban in seconds
     * Required when chatBanned is true
     * Maximum value is 2592000 seconds (30 days)
     */
    @JSONField(name = "chat_banned_duration")
    private Long chatBannedDuration;
    
    /**
     * Whether to send notification about this operation
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Extension data for the notification message
     * JSON format, max length 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Target tags to receive the notification
     * Default is the targetTag
     */
    @JSONField(name = "notification_target_tags")
    private String notificationTargetTags;
    
    /**
     * Default constructor
     */
    public ToggleTaggedMembersChatBanRequestV2() {
    }
    
    /**
     * Constructor with required fields
     * 
     * @param roomId chatroom ID
     * @param operatorAccountId operator account ID
     * @param targetTag tag of members to ban/unban
     * @param chatBanned whether to ban or unban
     */
    public ToggleTaggedMembersChatBanRequestV2(Long roomId, String operatorAccountId, String targetTag, Boolean chatBanned) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.targetTag = targetTag;
        this.chatBanned = chatBanned;
    }
    
    /**
     * Get chatroom ID
     * 
     * @return chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set chatroom ID
     * 
     * @param roomId chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get operator account ID
     * 
     * @return operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set operator account ID
     * 
     * @param operatorAccountId operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get target tag
     * 
     * @return target tag
     */
    public String getTargetTag() {
        return targetTag;
    }
    
    /**
     * Set target tag
     * 
     * @param targetTag target tag
     */
    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }
    
    /**
     * Get chat banned state
     * 
     * @return chat banned state
     */
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    /**
     * Set chat banned state
     * 
     * @param chatBanned chat banned state
     */
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    /**
     * Get chat banned duration
     * 
     * @return chat banned duration in seconds
     */
    public Long getChatBannedDuration() {
        return chatBannedDuration;
    }
    
    /**
     * Set chat banned duration
     * 
     * @param chatBannedDuration chat banned duration in seconds
     */
    public void setChatBannedDuration(Long chatBannedDuration) {
        this.chatBannedDuration = chatBannedDuration;
    }
    
    /**
     * Get notification enabled state
     * 
     * @return notification enabled state
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set notification enabled state
     * 
     * @param notificationEnabled notification enabled state
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    /**
     * Get notification extension
     * 
     * @return notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set notification extension
     * 
     * @param notificationExtension notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
    
    /**
     * Get notification target tags
     * 
     * @return notification target tags
     */
    public String getNotificationTargetTags() {
        return notificationTargetTags;
    }
    
    /**
     * Set notification target tags
     * 
     * @param notificationTargetTags notification target tags
     */
    public void setNotificationTargetTags(String notificationTargetTags) {
        this.notificationTargetTags = notificationTargetTags;
    }
} 