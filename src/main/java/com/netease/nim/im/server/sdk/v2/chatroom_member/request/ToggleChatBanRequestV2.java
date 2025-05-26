package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for banning/unbanning chatroom member from chatting
 * 
 * This class encapsulates the parameters required to set a chatroom member to a banned state
 * or remove them from that state.
 */
public class ToggleChatBanRequestV2 {

    /**
     * Account ID of the member (not serialized to JSON)
     */
    private String accountId;
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Operator account ID (must be creator or admin)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Whether to ban member from chatting
     * true: Ban the member
     * false: Unban the member
     */
    @JSONField(name = "chat_banned")
    private Boolean chatBanned;
    
    /**
     * Whether to send a notification after the operation
     * false (default): No notification
     * true: Send notification
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Notification extension field, JSON format, max length 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Default constructor
     */
    public ToggleChatBanRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the chatroom ID
     * @param operatorAccountId the operator's account ID
     * @param chatBanned whether to ban or unban
     */
    public ToggleChatBanRequestV2(Long roomId, String operatorAccountId, Boolean chatBanned) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
    }
    
    /**
     * Constructor with accountId and required parameters
     * 
     * @param accountId the account ID of the member to ban/unban
     * @param roomId the chatroom ID
     * @param operatorAccountId the operator's account ID
     * @param chatBanned whether to ban or unban
     */
    public ToggleChatBanRequestV2(String accountId, Long roomId, String operatorAccountId, Boolean chatBanned) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.chatBanned = chatBanned;
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
     * Get the chat banned state
     * 
     * @return true if chat should be banned, false otherwise
     */
    public Boolean getChatBanned() {
        return chatBanned;
    }
    
    /**
     * Set the chat banned state
     * 
     * @param chatBanned true to ban chat, false to unban
     */
    public void setChatBanned(Boolean chatBanned) {
        this.chatBanned = chatBanned;
    }
    
    /**
     * Check if notification is enabled
     * 
     * @return true if notification is enabled, false otherwise
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set whether notification is enabled
     * 
     * @param notificationEnabled true to enable notification, false to disable
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
    
    /**
     * Get the account ID
     * 
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set the account ID
     * 
     * @param accountId the account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
} 