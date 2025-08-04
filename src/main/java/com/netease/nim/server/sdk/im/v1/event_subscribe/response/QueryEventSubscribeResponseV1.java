package com.netease.nim.server.sdk.im.v1.event_subscribe.response;

import java.util.List;

/**
 * Response object for querying online status event subscriptions
 */
public class QueryEventSubscribeResponseV1 {
    /**
     * List of subscription information
     */
    private List<Subscription> subscribes;

    public List<Subscription> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Subscription> subscribes) {
        this.subscribes = subscribes;
    }

    /**
     * Subscription information
     */
    public static class Subscription {
        /**
         * Publisher account ID
         */
        private String accid;
        
        /**
         * Event type
         */
        private Integer eventType;
        
        /**
         * Expiration time (timestamp in milliseconds)
         */
        private Long expireTime;
        
        /**
         * Subscription time (timestamp in milliseconds)
         */
        private Long subscribeTime;

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

        public Long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }

        public Long getSubscribeTime() {
            return subscribeTime;
        }

        public void setSubscribeTime(Long subscribeTime) {
            this.subscribeTime = subscribeTime;
        }
    }
} 