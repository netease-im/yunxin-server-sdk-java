package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for temporarily banning/unbanning a chatroom member from chatting
 */
public class ToggleTempChatBanRequestV2 {
    
    /**
     * The ID of the chatroom
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * The account ID of the member to temporarily ban/unban
     * Not serialized as it's part of the URL path
     */
    @JSONField(serialize = false)
    private String accountId;
    
    /**
     * The account ID of the operator (must be creator or administrator)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Whether to set the member as banned
     * true: ban the member; false: unban the member
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Duration of the temporary ban in seconds
     * Required when chatBanned is true, maximum duration is 2592000 seconds (30 days)
     */
    @JSONField(name = "chat_banned_duration")
    private Long chatBannedDuration;
    
    /**
     * Whether to send a notification after the operation
     * true: send notification; false (default): don't send
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Additional information for notification message, in JSON format
     * Maximum length is 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Default constructor
     */
    public ToggleTempChatBanRequestV2() {
    }
    
    /**
     * Constructor with required fields
     * 
     * @param roomId the ID of the chatroom
     * @param accountId the account ID of the member to temporarily ban/unban
     * @param operatorAccountId the account ID of the operator
     * @param chatBanned whether to ban or unban the member
     */
    public ToggleTempChatBanRequestV2(Long roomId, String accountId, String operatorAccountId, Boolean chatBanned) {
        this.roomId = roomId;
        this.accountId = accountId;
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
    }
    
    /**
     * Constructor with required fields for banning
     * 
     * @param roomId the ID of the chatroom
     * @param accountId the account ID of the member to temporarily ban
     * @param operatorAccountId the account ID of the operator
     * @param chatBannedDuration duration of the temporary ban in seconds
     */
    public ToggleTempChatBanRequestV2(Long roomId, String accountId, String operatorAccountId, Long chatBannedDuration) {
        this.roomId = roomId;
        this.accountId = accountId;
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = true;
        this.chatBannedDuration = chatBannedDuration;
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return the chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId the chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get the account ID of the member to temporarily ban/unban
     * 
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set the account ID of the member to temporarily ban/unban
     * 
     * @param accountId the account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Get the operator account ID
     * 
     * @return the operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set the operator account ID
     * 
     * @param operatorAccountId the operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get whether to ban the member
     * 
     * @return whether to ban the member
     */
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    /**
     * Set whether to ban the member
     * 
     * @param chatBanned whether to ban the member
     */
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    /**
     * Get the duration of the temporary ban
     * 
     * @return the duration of the temporary ban in seconds
     */
    public Long getChatBannedDuration() {
        return chatBannedDuration;
    }
    
    /**
     * Set the duration of the temporary ban
     * 
     * @param chatBannedDuration the duration of the temporary ban in seconds
     */
    public void setChatBannedDuration(Long chatBannedDuration) {
        this.chatBannedDuration = chatBannedDuration;
    }
    
    /**
     * Get whether to send notification
     * 
     * @return whether to send notification
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set whether to send notification
     * 
     * @param notificationEnabled whether to send notification
     */
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    /**
     * Get the notification extension
     * 
     * @return the notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set the notification extension
     * 
     * @param notificationExtension the notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
} 