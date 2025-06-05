package com.netease.nim.server.sdk.im.v1.event_subscribe.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Request object for querying online status event subscriptions
 */
public class QueryEventSubscribeRequestV1 {
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
    
    /**
     * List of publisher account IDs to query subscription status
     */
    @YunxinParam("publisherAccids")
    private List<String> publisherAccids;

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

    public List<String> getPublisherAccids() {
        return publisherAccids;
    }

    public void setPublisherAccids(List<String> publisherAccids) {
        this.publisherAccids = publisherAccids;
    }
} 