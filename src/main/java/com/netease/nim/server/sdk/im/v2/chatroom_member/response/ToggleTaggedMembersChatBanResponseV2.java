package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class ToggleTaggedMembersChatBanResponseV2 {
    
    
    @JSONField(name = "mute_duration")
    private Long muteDuration;
    
    
    public ToggleTaggedMembersChatBanResponseV2() {
    }
    
    
    public ToggleTaggedMembersChatBanResponseV2(Long muteDuration) {
        this.muteDuration = muteDuration;
    }
    
    
    public Long getMuteDuration() {
        return muteDuration;
    }
    
    
    public void setMuteDuration(Long muteDuration) {
        this.muteDuration = muteDuration;
    }
} 