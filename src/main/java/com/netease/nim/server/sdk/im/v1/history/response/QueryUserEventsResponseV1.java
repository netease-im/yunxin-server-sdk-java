package com.netease.nim.server.sdk.im.v1.history.response;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

public class QueryUserEventsResponseV1 {

    /**
     * 总共记录数
     */
    private Integer size;

    /**
     * 记录集合
     */
    @JSONField(name="events")
    private List<UserEvent> events;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<UserEvent> getEvents() {
        return events;
    }

    public void setEvents(List<UserEvent> events) {
        this.events = events;
    }

    /**
     * 用户登录/登出事件记录
     */
    public static class UserEvent {

        /**
         * 用户accid
         */
        private String accid;

        /**
         * 发生时间，ms
         */
        private Long timestamp;

        /**
         * 事件类型：2表示登录，3表示登出
         */
        private Integer eventType;

        /**
         * 用户clientip
         */
        private String clientIp;

        /**
         * sdk版本
         */
        private Integer sdkVersion;

        /**
         * 终端类型
         */
        private String clientType;

        /**
         * 设备ID，可选字段
         */
        private String deviceId;

        /**
         * 登录时设置的自定义tag，可选字段
         */
        private String customTag;

        /**
         * 登录成功状态，200表示成功
         */
        private Integer code;

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public Integer getEventType() {
            return eventType;
        }

        public void setEventType(Integer eventType) {
            this.eventType = eventType;
        }

        public String getClientIp() {
            return clientIp;
        }

        public void setClientIp(String clientIp) {
            this.clientIp = clientIp;
        }

        public Integer getSdkVersion() {
            return sdkVersion;
        }

        public void setSdkVersion(Integer sdkVersion) {
            this.sdkVersion = sdkVersion;
        }

        public String getClientType() {
            return clientType;
        }

        public void setClientType(String clientType) {
            this.clientType = clientType;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getCustomTag() {
            return customTag;
        }

        public void setCustomTag(String customTag) {
            this.customTag = customTag;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }
}
