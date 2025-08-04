package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class ModifyMemberTagsRequestV2 {

    
    @JSONField(serialize = false)
    private String accountId;
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "tags")
    private List<String> tags;
    
    
    @JSONField(name = "notify_target_tags")
    private String notifyTargetTags;
    
    
    @JSONField(name = "notify_extension")
    private String notifyExtension;
    
    
    public ModifyMemberTagsRequestV2() {
    }
    
    
    public ModifyMemberTagsRequestV2(Long roomId, List<String> tags) {
        this.roomId = roomId;
        this.tags = tags;
    }
    
    
    public ModifyMemberTagsRequestV2(String accountId, Long roomId, List<String> tags) {
        this.accountId = accountId;
        this.roomId = roomId;
        this.tags = tags;
    }
    
    
    public String getAccountId() {
        return accountId;
    }
    
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public List<String> getTags() {
        return tags;
    }
    
    
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    
    public String getNotifyTargetTags() {
        return notifyTargetTags;
    }
    
    
    public void setNotifyTargetTags(String notifyTargetTags) {
        this.notifyTargetTags = notifyTargetTags;
    }
    
    
    public String getNotifyExtension() {
        return notifyExtension;
    }
    
    
    public void setNotifyExtension(String notifyExtension) {
        this.notifyExtension = notifyExtension;
    }
} 