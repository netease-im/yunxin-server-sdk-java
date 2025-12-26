package com.netease.nim.server.sdk.im.v2.system_push.request;

/**
 * Request for getting a single push notification
 * 
 * API: GET https://open.yunxinapi.com/im/v2/push_notification/:push_id
 */
public class GetPushNotificationRequestV2 {
    
    private Long pushId;
    
    public GetPushNotificationRequestV2() {
    }
    
    public GetPushNotificationRequestV2(Long pushId) {
        this.pushId = pushId;
    }
    
    public Long getPushId() {
        return pushId;
    }
    
    public void setPushId(Long pushId) {
        this.pushId = pushId;
    }
}

