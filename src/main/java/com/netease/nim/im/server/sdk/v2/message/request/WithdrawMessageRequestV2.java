package com.netease.nim.im.server.sdk.v2.message.request;

/**
 * Request object for withdrawing (recalling or deleting) a message
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/conversations/{conversation_id}/messages/{message_server_id}
 * 
 * This API supports three types of operations:
 * - type=1: Unilateral recall - Recalls a P2P or advanced team message within 30 days.
 *   After recall, the message receiver will receive a notification and corresponding messages
 *   will be deleted. The message sender will not be notified and can continue to use the messages.
 * 
 * - type=2: Bilateral recall - Recalls P2P, advanced team, and super team messages within a
 *   configurable time (default 2 minutes, max 7 days). After recall, both the message receiver
 *   and sender will receive a notification, and corresponding messages will be deleted.
 * 
 * - type=3: Delete message - Deletes P2P and advanced team messages within 30 days.
 *   When deleting a message, the corresponding messages will be deleted without notification.
 */
public class WithdrawMessageRequestV2 {
    
    private String conversationId;
    private Long messageServerId;
    private Integer type;
    private String description;
    private String pushContent;
    private String pushPayload;
    private String routeEnvironment;
    private String attach;
    private Boolean checkTeamMemberValid;
    private Long messageTime;
    private Boolean ignoreRevokeTime;
    
    /**
     * Default constructor
     */
    public WithdrawMessageRequestV2() {
    }
    
    /**
     * Constructor with basic parameters
     * 
     * @param conversationId the conversation ID
     * @param messageServerId the message server ID
     * @param type the operation type:
     *             1 - Unilateral recall
     *             2 - Bilateral recall
     *             3 - Delete message
     */
    public WithdrawMessageRequestV2(String conversationId, Long messageServerId, Integer type) {
        this.conversationId = conversationId;
        this.messageServerId = messageServerId;
        this.type = type;
    }

    // Getters and setters
    
    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Long getMessageServerId() {
        return messageServerId;
    }

    public void setMessageServerId(Long messageServerId) {
        this.messageServerId = messageServerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRouteEnvironment() {
        return routeEnvironment;
    }

    public void setRouteEnvironment(String routeEnvironment) {
        this.routeEnvironment = routeEnvironment;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public Boolean getCheckTeamMemberValid() {
        return checkTeamMemberValid;
    }

    public void setCheckTeamMemberValid(Boolean checkTeamMemberValid) {
        this.checkTeamMemberValid = checkTeamMemberValid;
    }

    public Long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Long messageTime) {
        this.messageTime = messageTime;
    }

    public Boolean getIgnoreRevokeTime() {
        return ignoreRevokeTime;
    }

    public void setIgnoreRevokeTime(Boolean ignoreRevokeTime) {
        this.ignoreRevokeTime = ignoreRevokeTime;
    }
} 