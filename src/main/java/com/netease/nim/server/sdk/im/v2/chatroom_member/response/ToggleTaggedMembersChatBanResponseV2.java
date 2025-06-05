package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for toggling chat ban on chatroom members with a specific tag
 * 
 * This response contains information about the applied mute duration.
 */
public class ToggleTaggedMembersChatBanResponseV2 {
    
    /**
     * Duration of the mute in seconds
     */
    @JSONField(name = "mute_duration")
    private Long muteDuration;
    
    /**
     * Default constructor
     */
    public ToggleTaggedMembersChatBanResponseV2() {
    }
    
    /**
     * Constructor with mute duration
     * 
     * @param muteDuration the duration of the mute in seconds
     */
    public ToggleTaggedMembersChatBanResponseV2(Long muteDuration) {
        this.muteDuration = muteDuration;
    }
    
    /**
     * Get mute duration
     * 
     * @return mute duration in seconds
     */
    public Long getMuteDuration() {
        return muteDuration;
    }
    
    /**
     * Set mute duration
     * 
     * @param muteDuration mute duration in seconds
     */
    public void setMuteDuration(Long muteDuration) {
        this.muteDuration = muteDuration;
    }
} 