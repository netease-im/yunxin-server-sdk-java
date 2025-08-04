package com.netease.nim.server.sdk.im.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class DeleteVirtualMembersRequestV2 {
    
    
    @JSONField(name = "room_id")
    private Long roomId;
    
    
    @JSONField(name = "account_ids")
    private List<String> accountIds;
    
    
    @JSONField(name = "notification_enabled")
    private Boolean notificationEnabled;
    
    
    public DeleteVirtualMembersRequestV2() {
    }
    
    
    public DeleteVirtualMembersRequestV2(Long roomId, List<String> accountIds) {
        this.roomId = roomId;
        this.accountIds = accountIds;
    }
    
    
    public Long getRoomId() {
        return roomId;
    }
    
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    
    public List<String> getAccountIds() {
        return accountIds;
    }
    
    
    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
    
    
    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }
    
    
    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
} 