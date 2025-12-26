package com.netease.nim.server.sdk.im.v2.system_push.request;

/**
 * Request for listing push notifications with pagination
 * 
 * API: GET https://open.yunxinapi.com/im/v2/push_notification
 */
public class ListPushNotificationsRequestV2 {
    
    private String pageToken;
    
    private Integer limit;
    
    private Integer type;
    
    public ListPushNotificationsRequestV2() {
    }
    
    public String getPageToken() {
        return pageToken;
    }
    
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }
    
    public Integer getLimit() {
        return limit;
    }
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
}

