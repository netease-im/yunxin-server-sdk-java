package com.netease.nim.server.sdk.im.v2.message.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;


public class QueryTeamReadReceiptResponseV2 {
    
    @JSONField(name = "read_size")
    private Integer readSize;           // Number of users who have read the message
    
    @JSONField(name = "unread_size")
    private Integer unreadSize;         // Number of users who have not read the message
    
    @JSONField(name = "read_account_ids")
    private List<String> readAccountIds;    // List of account IDs who have read the message
    
    @JSONField(name = "unread_account_ids")
    private List<String> unreadAccountIds;  // List of account IDs who have not read the message
    
    
    public QueryTeamReadReceiptResponseV2() {
    }
    
    
    public Integer getReadSize() {
        return readSize;
    }
    
    
    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }
    
    
    public Integer getUnreadSize() {
        return unreadSize;
    }
    
    
    public void setUnreadSize(Integer unreadSize) {
        this.unreadSize = unreadSize;
    }
    
    
    public List<String> getReadAccountIds() {
        return readAccountIds;
    }
    
    
    public void setReadAccountIds(List<String> readAccountIds) {
        this.readAccountIds = readAccountIds;
    }
    
    
    public List<String> getUnreadAccountIds() {
        return unreadAccountIds;
    }
    
    
    public void setUnreadAccountIds(List<String> unreadAccountIds) {
        this.unreadAccountIds = unreadAccountIds;
    }
} 