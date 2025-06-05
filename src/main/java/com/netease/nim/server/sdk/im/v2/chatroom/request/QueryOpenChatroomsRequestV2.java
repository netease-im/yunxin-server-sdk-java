package com.netease.nim.server.sdk.im.v2.chatroom.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for querying open chatrooms
 * 
 * API: GET https://open.yunxinapi.com/im/v2/chatrooms/actions/opend_chatrooms
 * 
 * This class encapsulates the parameters required to query open chatrooms
 * created by a specific account.
 */
public class QueryOpenChatroomsRequestV2 {

    /**
     * Chatroom creator account ID
     */
    @JSONField(name = "creator_account_id")
    private String creatorAccountId;
    
    /**
     * Default constructor
     */
    public QueryOpenChatroomsRequestV2() {
    }
    
    /**
     * Constructor with creator account ID
     * 
     * @param creatorAccountId The creator account ID
     */
    public QueryOpenChatroomsRequestV2(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }
    
    /**
     * Get the creator account ID
     * 
     * @return The creator account ID
     */
    public String getCreatorAccountId() {
        return creatorAccountId;
    }
    
    /**
     * Set the creator account ID
     * 
     * @param creatorAccountId The creator account ID
     */
    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }
} 