package com.netease.nim.im.server.sdk.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response for querying open chatrooms
 * 
 * This class encapsulates the response for retrieving a list of open chatrooms created by a specific account.
 * The response contains a list of chatroom IDs that are currently in the open state.
 */
public class QueryOpenChatroomsResponseV2 {
    
    /**
     * List of open chatroom IDs
     */
    @JSONField(name = "items")
    private List<String> items;
    
    /**
     * Default constructor
     */
    public QueryOpenChatroomsResponseV2() {
    }
    
    /**
     * Constructor with items
     * 
     * @param items the list of open chatroom IDs
     */
    public QueryOpenChatroomsResponseV2(List<String> items) {
        this.items = items;
    }
    
    /**
     * Get the list of open chatroom IDs
     * 
     * @return the list of open chatroom IDs
     */
    public List<String> getItems() {
        return items;
    }
    
    /**
     * Set the list of open chatroom IDs
     * 
     * @param items the list of open chatroom IDs
     */
    public void setItems(List<String> items) {
        this.items = items;
    }
} 