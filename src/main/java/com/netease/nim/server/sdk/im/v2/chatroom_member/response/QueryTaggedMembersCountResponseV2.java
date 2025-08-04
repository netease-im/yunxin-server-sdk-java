package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class QueryTaggedMembersCountResponseV2 {
    
    
    @JSONField(name = "tag")
    private String tag;
    
    
    @JSONField(name = "online_user_count")
    private Long onlineUserCount;
    
    
    public QueryTaggedMembersCountResponseV2() {
    }
    
    
    public QueryTaggedMembersCountResponseV2(String tag, Long onlineUserCount) {
        this.tag = tag;
        this.onlineUserCount = onlineUserCount;
    }
    
    
    public String getTag() {
        return tag;
    }
    
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
    public Long getOnlineUserCount() {
        return onlineUserCount;
    }
    
    
    public void setOnlineUserCount(Long onlineUserCount) {
        this.onlineUserCount = onlineUserCount;
    }
} 