package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for adding quick comment to a message
 * 
 * API: PATCH https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
 */
public class AddQuickCommentResponseV2 {
    
    private Long time;            // Timestamp when the comment was added
    
    /**
     * Default constructor
     */
    public AddQuickCommentResponseV2() {
    }
    
    /**
     * Constructor with parameters
     * 
     * @param time Timestamp when the comment was added
     */
    public AddQuickCommentResponseV2(Long time) {
        this.time = time;
    }
    
    // Getters and Setters
    
    public Long getTime() {
        return time;
    }
    
    public void setTime(Long time) {
        this.time = time;
    }
} 