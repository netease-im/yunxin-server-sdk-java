package com.netease.nim.server.sdk.im.v1.event_subscribe.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Request object for batch deleting all online status event subscriptions
 */
public class BatchDeleteEventSubscribeRequestV1 {
    /**
     * Event subscriber account ID
     */
    @YunxinParam("accid")
    private String accid;
    
    /**
     * Event type, fixed to 1 for online status events
     */
    @YunxinParam("eventType")
    private Integer eventType = 1;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }
} 