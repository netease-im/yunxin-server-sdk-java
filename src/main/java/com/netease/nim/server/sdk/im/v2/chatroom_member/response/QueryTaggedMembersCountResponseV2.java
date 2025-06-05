package com.netease.nim.server.sdk.im.v2.chatroom_member.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for querying the count of online members with a specific tag in a chatroom
 */
public class QueryTaggedMembersCountResponseV2 {
    
    /**
     * The tag that was queried
     */
    @JSONField(name = "tag")
    private String tag;
    
    /**
     * The count of online users with this tag
     */
    @JSONField(name = "online_user_count")
    private Long onlineUserCount;
    
    /**
     * Default constructor
     */
    public QueryTaggedMembersCountResponseV2() {
    }
    
    /**
     * Constructor with all fields
     * 
     * @param tag the tag that was queried
     * @param onlineUserCount the count of online users with this tag
     */
    public QueryTaggedMembersCountResponseV2(String tag, Long onlineUserCount) {
        this.tag = tag;
        this.onlineUserCount = onlineUserCount;
    }
    
    /**
     * Get the tag
     * 
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * Set the tag
     * 
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    /**
     * Get the online user count
     * 
     * @return the online user count
     */
    public Long getOnlineUserCount() {
        return onlineUserCount;
    }
    
    /**
     * Set the online user count
     * 
     * @param onlineUserCount the online user count
     */
    public void setOnlineUserCount(Long onlineUserCount) {
        this.onlineUserCount = onlineUserCount;
    }
} 