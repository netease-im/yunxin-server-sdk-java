package com.netease.nim.im.server.sdk.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for temporarily banning/unbanning a chatroom member from chatting
 */
public class ToggleTempChatBanResponseV2 {
    
    /**
     * Duration of the temporary ban in seconds
     */
    @JSONField(name = "mute_duration")
    private Long muteDuration;
    
    /**
     * Default constructor
     */
    public ToggleTempChatBanResponseV2() {
    }
    
    /**
     * Constructor with all fields
     * 
     * @param muteDuration duration of the temporary ban in seconds
     */
    public ToggleTempChatBanResponseV2(Long muteDuration) {
        this.muteDuration = muteDuration;
    }
    
    /**
     * Get the mute duration
     * 
     * @return the mute duration in seconds
     */
    public Long getMuteDuration() {
        return muteDuration;
    }
    
    /**
     * Set the mute duration
     * 
     * @param muteDuration the mute duration in seconds
     */
    public void setMuteDuration(Long muteDuration) {
        this.muteDuration = muteDuration;
    }
} 