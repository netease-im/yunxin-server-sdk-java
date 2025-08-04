package com.netease.nim.server.sdk.im.v1.event_subscribe.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

/**
 * Request object for adding online status event subscriptions
 */
public class AddEventSubscribeRequestV1 {
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
     * List of publisher account IDs to subscribe to
     */
    @YunxinParam("publisherAccids")
    private List<String> publisherAccids;
    
    /**
     * Time-to-live for the subscription in seconds (60-2592000, i.e., 60 seconds to 30 days)
     */
    @YunxinParam("ttl")
    private Long ttl;

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

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
} 