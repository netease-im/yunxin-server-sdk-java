package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class GetChatroomAddressResponseV2 {
    
    
    @JSONField(name = "items")
    private List<String> items;
    
    
    public GetChatroomAddressResponseV2() {
    }
    
    
    public GetChatroomAddressResponseV2(List<String> items) {
        this.items = items;
    }
    
    
    public List<String> getItems() {
        return items;
    }
    
    
    public void setItems(List<String> items) {
        this.items = items;
    }
} 