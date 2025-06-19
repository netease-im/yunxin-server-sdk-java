package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for toggling chatroom mute status
 * 
 * This class encapsulates the parameters required to set or cancel global mute status on a chatroom.
 * When a chatroom is muted, only the creator and administrators can send messages.
 */
public class ToggleChatroomMuteRequestV2 {

    @JSONField(serialize = false)
    private Long roomId;

    /**
     * Operator account ID (must be the chatroom creator or an administrator)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Whether to set the chatroom to muted status
     * true: Enable global mute (only creator and admins can send messages)
     * false: Disable global mute
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Whether to send a notification about the mute status change
     * true (default): Send notification
     * false: Don't send notification
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Notification event extension field
     * Maximum length: 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Default constructor
     */
    public ToggleChatroomMuteRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param operatorAccountId The account ID of the operator (must be the chatroom creator or an admin)
     * @param chatBanned Whether to set the chatroom to muted status
     */
    public ToggleChatroomMuteRequestV2(String operatorAccountId, Boolean chatBanned) {
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param operatorAccountId The account ID of the operator (must be the chatroom creator or an admin)
     * @param chatBanned Whether to set the chatroom to muted status
     * @param notificationEnabled Whether to send a notification about the mute status change
     * @param notificationExtension The notification event extension field
     */
    public ToggleChatroomMuteRequestV2(String operatorAccountId, Boolean chatBanned, 
            Boolean notificationEnabled, String notificationExtension) {
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
        this.notificationEnabled = notificationEnabled;
        this.notificationExtension = notificationExtension;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * Get the operator account ID
     * 
     * @return The operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set the operator account ID
     * 
     * @param operatorAccountId The operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get whether the chatroom is muted
     * 
     * @return Whether the chatroom is muted
     */
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    /**
     * Set whether the chatroom is muted
     * 
     * @param chatBanned Whether the chatroom is muted
     */
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    /**
     * Get whether to send notification
     * 
     * @return Whether to send notification
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set whether to send notification
     * 
     * @param notificationEnabled Whether to send notification
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    /**
     * Get the notification extension
     * 
     * @return The notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set the notification extension
     * 
     * @param notificationExtension The notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
} 