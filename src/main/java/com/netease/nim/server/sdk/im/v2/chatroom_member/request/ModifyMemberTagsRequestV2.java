package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for modifying online chatroom member tags
 * 
 * This class encapsulates the parameters required to modify an online chatroom member's tags.
 */
public class ModifyMemberTagsRequestV2 {

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
     * Tags to set for the member
     * Multiple tags can be set as a JSON array, e.g. ["tag1", "tag2"]
     */
    @JSONField(name = "tags")
    private List<String> tags;
    
    /**
     * Notification target tags
     * Tag expression for users to be notified after the change
     * Also affects the notification targets when the user disconnects
     */
    @JSONField(name = "notify_target_tags")
    private String notifyTargetTags;
    
    /**
     * Notification extension field, max length 2048 characters
     */
    @JSONField(name = "notify_extension")
    private String notifyExtension;
    
    /**
     * Default constructor
     */
    public ModifyMemberTagsRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the chatroom ID
     * @param tags the tags to set
     */
    public ModifyMemberTagsRequestV2(Long roomId, List<String> tags) {
        this.roomId = roomId;
        this.tags = tags;
    }
    
    /**
     * Constructor with accountId and required parameters
     * 
     * @param accountId the account ID of the member
     * @param roomId the chatroom ID
     * @param tags the tags to set
     */
    public ModifyMemberTagsRequestV2(String accountId, Long roomId, List<String> tags) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.tags = tags;
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
     * Get the tags
     * 
     * @return the list of tags
     */
    public List<String> getTags() {
        return tags;
    }
    
    /**
     * Set the tags
     * 
     * @param tags the list of tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    /**
     * Get the notification target tags
     * 
     * @return the notification target tags
     */
    public String getNotifyTargetTags() {
        return notifyTargetTags;
    }
    
    /**
     * Set the notification target tags
     * 
     * @param notifyTargetTags the notification target tags
     */
    public void setNotifyTargetTags(String notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }
    
    /**
     * Get the notification extension
     * 
     * @return the notification extension
     */
    public String getNotifyExtension() {
        return notifyExtension;
    }
    
    /**
     * Set the notification extension
     * 
     * @param notifyExtension the notification extension
     */
    public void setNotifyExtension(String notifyExtension) {
        this.notifyExtension = notifyExtension;
    }
} 