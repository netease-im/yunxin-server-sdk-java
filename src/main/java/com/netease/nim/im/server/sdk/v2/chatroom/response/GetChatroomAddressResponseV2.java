package com.netease.nim.im.server.sdk.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for getting chatroom address
 * 
 * This class encapsulates the response data containing chatroom addresses.
 */
public class GetChatroomAddressResponseV2 {
    
    /**
     * List of chatroom addresses
     */
    @JSONField(name = "items")
    private List<String> items;
    
    /**
     * Default constructor
     */
    public GetChatroomAddressResponseV2() {
    }
    
    /**
     * Constructor with chatroom addresses
     * 
     * @param items List of chatroom addresses
     */
    public GetChatroomAddressResponseV2(List<String> items) {
        this.items = items;
    }
    
    /**
     * Get the list of chatroom addresses
     * 
     * @return List of chatroom addresses
     */
    public List<String> getItems() {
        return items;
    }
    
    /**
     * Set the list of chatroom addresses
     * 
     * @param items List of chatroom addresses
     */
    public void setItems(List<String> items) {
        this.items = items;
    }
} 