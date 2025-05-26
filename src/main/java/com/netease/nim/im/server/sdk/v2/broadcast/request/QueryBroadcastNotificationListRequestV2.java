package com.netease.nim.im.server.sdk.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Request for paginated query of broadcast notifications
 * 
 * API: GET https://open.yunxinapi.com/im/v2/broadcast_notification
 */
public class QueryBroadcastNotificationListRequestV2 {
    
    /**
     * Optional. Page token for pagination. If empty, query starts from the first page.
     */
    @JSONField(name = "page_token")
    private String pageToken;
    
    /**
     * Optional. Number of broadcast messages per page, maximum is 100.
     * If the value is less than or equal to 0, the default value is 100.
     */
    @JSONField(name = "limit")
    private Integer limit;
    
    /**
     * Optional. Query type.
     * 1: Query all broadcast messages (default)
     * 2: Query offline broadcast messages
     * 3: Query non-offline broadcast messages
     */
    @JSONField(name = "type")
    private Integer type;
    
    /**
     * Default constructor
     */
    public QueryBroadcastNotificationListRequestV2() {
        // Default values
        this.type = 1;
        this.limit = 100;
    }
    
    /**
     * Get page token
     * 
     * @return Page token for pagination
     */
    public String getPageToken() {
        return pageToken;
    }
    
    /**
     * Set page token
     * 
     * @param pageToken Page token for pagination
     */
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    /**
     * Get limit
     * 
     * @return Number of broadcast messages per page
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * Set limit
     * 
     * @param limit Number of broadcast messages per page
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    /**
     * Get query type
     * 
     * @return Query type
     */
    public Integer getType() {
        return type;
    }
    
    /**
     * Set query type
     * 
     * @param type Query type (1, 2, or 3)
     */
    public void setType(Integer type) {
        if (type != null && (type == 1 || type == 2 || type == 3)) {
            this.type = type;
        } else {
            this.type = 1;
        }
    }
} 