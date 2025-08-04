package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;


public class DeleteQuickCommentResponseV2 {
    
    private Long time;            // 删除快捷评论的服务器时间
    
    
    public DeleteQuickCommentResponseV2() {
    }
    
    
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