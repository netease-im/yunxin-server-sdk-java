package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class QueryOpenChatroomsResponseV2 {
    
    
    @JSONField(name = "items")
    private List<String> items;
    
    
    public QueryOpenChatroomsResponseV2() {
    }
    
    
    public List<String> getItems() {
        return items;
    }
    
    
    public void setItems(List<String> items) {
        this.items = items;
    }
} 