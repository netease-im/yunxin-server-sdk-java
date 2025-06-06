package com.netease.nim.server.sdk.im.v2.chatroom.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

/**
 * Response for querying open chatrooms
 * 
 * API: GET https://open.yunxinapi.com/im/v2/chatrooms/actions/opend_chatrooms
 * 
 * This class encapsulates the response for querying open chatrooms created by a specific account.
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
     * Get the list of open chatroom IDs
     * 
     * @return List of open chatroom IDs
     */
    public List<String> getItems() {
        return items;
    }
    
    /**
     * Set the list of open chatroom IDs
     * 
     * @param items List of open chatroom IDs
     */
    public void setItems(List<String> items) {
        this.items = items;
    }
} 