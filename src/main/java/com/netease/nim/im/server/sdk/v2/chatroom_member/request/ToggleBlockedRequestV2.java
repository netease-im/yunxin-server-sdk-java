package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for blocking/unblocking a chatroom member
 */
public class ToggleBlockedRequestV2 {
    
    /**
     * Account ID of the member to block/unblock
     */
    @JSONField(name = "account_id")
    private String accountId;
    
    /**
     * Chatroom ID
     */
    @JSONField(name = "room_id")
    private Long roomId;
    
    /**
     * Operator's account ID (must be creator or admin)
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Whether to block the member
     * true: block the member
     * false: unblock the member
     */
    @JSONField(name = "blocked")
    private Boolean blocked;
    
    /**
     * Whether to send notification after the operation
     * Default is false
     */
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    /**
     * Extension field for notification, JSON format
     * Maximum length is 2048 characters
     */
    @JSONField(name = "notification_extension")
    private String notificationExtension;
    
    /**
     * Default constructor
     */
    public ToggleBlockedRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     *
     * @param accountId Account ID of the member to block/unblock
     * @param roomId Chatroom ID
     * @param operatorAccountId Operator's account ID
     * @param blocked Whether to block the member
     */
    public ToggleBlockedRequestV2(String accountId, Long roomId, String operatorAccountId, Boolean blocked) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.blocked = blocked;
    }
    
    /**
     * Get account ID of the member to block/unblock
     *
     * @return Account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set account ID of the member to block/unblock
     *
     * @param accountId Account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Get chatroom ID
     *
     * @return Chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set chatroom ID
     *
     * @param roomId Chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get operator's account ID
     *
     * @return Operator's account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }
    
    /**
     * Set operator's account ID
     *
     * @param operatorAccountId Operator's account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Get whether to block the member
     *
     * @return Whether to block the member
     */
    public Boolean getBlocked() {
        return blocked;
    }
    
    /**
     * Set whether to block the member
     *
     * @param blocked Whether to block the member
     */
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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
     * Get notification extension
     *
     * @return Notification extension
     */
    public String getNotificationExtension() {
        return notificationExtension;
    }
    
    /**
     * Set notification extension
     *
     * @param notificationExtension Notification extension
     */
    public void setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
    }
} 