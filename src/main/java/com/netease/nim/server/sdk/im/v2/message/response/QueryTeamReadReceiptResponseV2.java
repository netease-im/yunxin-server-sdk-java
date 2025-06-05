package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying team message read receipt details
 * 
 * API: GET https://open.yunxinapi.com/im/v2/messages/actions/team_read_receipt
 */
public class QueryTeamReadReceiptResponseV2 {
    
    @JSONField(name = "read_size")
    private Integer readSize;           // Number of users who have read the message
    
    @JSONField(name = "unread_size")
    private Integer unreadSize;         // Number of users who have not read the message
    
    @JSONField(name = "read_account_ids")
    private List<String> readAccountIds;    // List of account IDs who have read the message
    
    @JSONField(name = "unread_account_ids")
    private List<String> unreadAccountIds;  // List of account IDs who have not read the message
    
    /**
     * Default constructor
     */
    public QueryTeamReadReceiptResponseV2() {
    }
    
    /**
     * Get the number of users who have read the message
     * 
     * @return Number of users who have read the message
     */
    public Integer getReadSize() {
        return readSize;
    }
    
    /**
     * Set the number of users who have read the message
     * 
     * @param readSize Number of users who have read the message
     */
    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }
    
    /**
     * Get the number of users who have not read the message
     * 
     * @return Number of users who have not read the message
     */
    public Integer getUnreadSize() {
        return unreadSize;
    }
    
    /**
     * Set the number of users who have not read the message
     * 
     * @param unreadSize Number of users who have not read the message
     */
    public void setUnreadSize(Integer unreadSize) {
        this.unreadSize = unreadSize;
    }
    
    /**
     * Get the list of account IDs who have read the message
     * 
     * @return List of account IDs who have read the message
     */
    public List<String> getReadAccountIds() {
        return readAccountIds;
    }
    
    /**
     * Set the list of account IDs who have read the message
     * 
     * @param readAccountIds List of account IDs who have read the message
     */
    public void setReadAccountIds(List<String> readAccountIds) {
        this.readAccountIds = readAccountIds;
    }
    
    /**
     * Get the list of account IDs who have not read the message
     * 
     * @return List of account IDs who have not read the message
     */
    public List<String> getUnreadAccountIds() {
        return unreadAccountIds;
    }
    
    /**
     * Set the list of account IDs who have not read the message
     * 
     * @param unreadAccountIds List of account IDs who have not read the message
     */
    public void setUnreadAccountIds(List<String> unreadAccountIds) {
        this.unreadAccountIds = unreadAccountIds;
    }
} 