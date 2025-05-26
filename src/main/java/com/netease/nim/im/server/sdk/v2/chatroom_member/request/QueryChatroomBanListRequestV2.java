package com.netease.nim.im.server.sdk.v2.chatroom_member.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for querying chatroom ban list
 * 
 * API: GET https://open.yunxinapi.com/im/v2/room_members/{room_id}/actions/banned_members
 */
public class QueryChatroomBanListRequestV2 {
    
    /**
     * Chatroom ID (used in path parameter)
     */
    private Long roomId;
    
    /**
     * Account ID of the operator who is querying the ban list
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    
    /**
     * Marker for pagination
     * Use the marker from the previous response to get the next page of results
     */
    @JSONField(name = "marker")
    private String marker;
    
    /**
     * Number of banned members to retrieve per page
     * Default is 20, maximum is 100
     */
    @JSONField(name = "limit")
    private Integer limit;
    
    /**
     * Default constructor
     */
    public QueryChatroomBanListRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId the chatroom ID
     * @param operatorAccountId the operator account ID (must be creator or admin)
     */
    public QueryChatroomBanListRequestV2(Long roomId, String operatorAccountId) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param roomId the chatroom ID
     * @param operatorAccountId the operator account ID (must be creator or admin)
     * @param marker the pagination marker
     * @param limit the number of items per page
     */
    public QueryChatroomBanListRequestV2(Long roomId, String operatorAccountId, String marker, Integer limit) {
        this.roomId = roomId;
        this.operatorAccountId = operatorAccountId;
        this.marker = marker;
        this.limit = limit;
    }

    /**
     * Get the chatroom ID
     * 
     * @return the chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * Set the chatroom ID
     * 
     * @param roomId the chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * Get the operator account ID
     * 
     * @return the operator account ID
     */
    public String getOperatorAccountId() {
        return operatorAccountId;
    }

    /**
     * Set the operator account ID
     * 
     * @param operatorAccountId the operator account ID
     */
    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }

    /**
     * Get the pagination marker
     * 
     * @return the pagination marker
     */
    public String getMarker() {
        return marker;
    }

    /**
     * Set the pagination marker
     * 
     * @param marker the pagination marker
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * Get the number of items per page
     * 
     * @return the number of items per page
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Set the number of items per page
     * 
     * @param limit the number of items per page
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
} 