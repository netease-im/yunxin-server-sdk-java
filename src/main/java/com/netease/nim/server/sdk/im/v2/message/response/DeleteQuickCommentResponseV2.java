package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Response for deleting quick comment from a message
 * 
 * API: DELETE https://open.yunxinapi.com/im/v2/messages/actions/quick_comment
 */
public class DeleteQuickCommentResponseV2 {
    
    private Long time;            // 删除快捷评论的服务器时间
    
    /**
     * 默认构造函数
     */
    public DeleteQuickCommentResponseV2() {
    }
    
    /**
     * 构造函数
     * 
     * @param time 删除快捷评论的服务器时间
     */
    public DeleteQuickCommentResponseV2(Long time) {
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