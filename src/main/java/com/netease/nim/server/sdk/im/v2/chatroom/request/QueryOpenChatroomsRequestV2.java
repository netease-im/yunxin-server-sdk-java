package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;


public class QueryOpenChatroomsRequestV2 {

    
    @JSONField(name = "creator_account_id")
    private String creatorAccountId;
    
    
    public QueryOpenChatroomsRequestV2() {
    }
    
    
    public QueryOpenChatroomsRequestV2(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }
    
    
    public String getCreatorAccountId() {
        return creatorAccountId;
    }
    
    
    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }
} 