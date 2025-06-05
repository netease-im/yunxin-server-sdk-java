package com.netease.nim.server.sdk.im.v2.chatroom_message.request;

/**
 * Request class for recalling or deleting a chatroom message
 * 
 * This class encapsulates the parameters for recalling a message in a chatroom:
 * - When notificationEnabled=true: It's a recall operation and a notification will be sent to clients.
 * - When notificationEnabled=false: It's a delete operation and no notification will be sent.
 */
public class RecallChatroomMessageRequestV2 {
    
    private Long roomId;
    private String messageClientId;
    private String operatorId;
    private String senderId;
    private Long createTime;
    private Boolean notificationEnabled;
    private String notificationExtension;
    
    /**
     * Default constructor
     */
    public RecallChatroomMessageRequestV2() {
    }
    
    /**
     * Convenience constructor for creating a recall request
     * 
     * @param roomId the ID of the chatroom
     * @param messageClientId the client ID of the message to recall
     * @param operatorId the ID of the account performing the recall operation
     * @param senderId the ID of the account that originally sent the message
     * @param createTime the timestamp when the message was created
     * @param notificationEnabled whether to send a notification (true for recall, false for delete)
     */
    public RecallChatroomMessageRequestV2(Long roomId, String messageClientId, String operatorId, 
                                          String senderId, Long createTime, Boolean notificationEnabled) {
        this.roomId = roomId;
        this.messageClientId = messageClientId;
        this.operatorId = operatorId;
        this.senderId = senderId;
        this.createTime = createTime;
        this.notificationEnabled = notificationEnabled;
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
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setRoomId(Long roomId) {
        this.roomId = roomId;
        return this;
    }
    
    /**
     * Get the message client ID
     * 
     * @return the message client ID
     */
    public String getMessageClientId() {
        return messageClientId;
    }
    
    /**
     * Set the message client ID
     * 
     * @param messageClientId the message client ID
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setMessageClientId(String messageClientId) {
        this.messageClientId = messageClientId;
        return this;
    }
    
    /**
     * Get the operator ID
     * 
     * @return the operator ID
     */
    public String getOperatorId() {
        return operatorId;
    }
    
    /**
     * Set the operator ID
     * 
     * @param operatorId the operator ID
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }
    
    /**
     * Get the sender ID
     * 
     * @return the sender ID
     */
    public String getSenderId() {
        return senderId;
    }
    
    /**
     * Set the sender ID
     * 
     * @param senderId the sender ID
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }
    
    /**
     * Get the create time
     * 
     * @return the create time
     */
    public Long getCreateTime() {
        return createTime;
    }
    
    /**
     * Set the create time
     * 
     * @param createTime the create time
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }
    
    /**
     * Get whether notification is enabled
     * 
     * @return true if notification is enabled, false otherwise
     */
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    /**
     * Set whether notification is enabled
     * 
     * @param notificationEnabled true to enable notification, false otherwise
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
        return this;
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
     * @return this request for chaining
     */
    public RecallChatroomMessageRequestV2 setNotificationExtension(String notificationExtension) {
        this.notificationExtension = notificationExtension;
        return this;
    }
} 