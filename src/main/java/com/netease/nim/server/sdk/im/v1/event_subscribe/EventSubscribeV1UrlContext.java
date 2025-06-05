package com.netease.nim.server.sdk.im.v1.event_subscribe;

/**
 * URL constants for event subscription API endpoints
 */
public class EventSubscribeUrlContext {
    /**
     * URL for adding event subscription
     */
    public static final String ADD_EVENT_SUBSCRIBE = "/event/subscribe/add.action";
    
    /**
     * URL for querying event subscription
     */
    public static final String QUERY_EVENT_SUBSCRIBE = "/event/subscribe/query.action";
    
    /**
     * URL for deleting specific event subscriptions
     */
    public static final String DELETE_EVENT_SUBSCRIBE = "/event/subscribe/delete.action";
    
    /**
     * URL for batch deleting all event subscriptions
     */
    public static final String BATCH_DELETE_EVENT_SUBSCRIBE = "/event/subscribe/batchdel.action";
} 