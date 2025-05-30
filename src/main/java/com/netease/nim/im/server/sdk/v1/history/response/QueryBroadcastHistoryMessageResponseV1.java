package com.netease.nim.im.server.sdk.v1.history.response;

import java.util.List;
import java.util.Map;

public class QueryBroadcastHistoryMessageResponseV1 {

    /**
     * 广播消息列表
     */
    private List<BroadcastMessage> msgs;

    public List<BroadcastMessage> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<BroadcastMessage> msgs) {
        this.msgs = msgs;
    }

    /**
     * 广播消息对象
     */
    public static class BroadcastMessage {
        /**
         * 广播消息ID
         */
        private Long broadcastId;
        
        /**
         * 消息内容
         */
        private String body;
        
        /**
         * 创建时间，毫秒数
         */
        private Long createTime;
        
        /**
         * 过期时间，毫秒数
         */
        private Long expireTime;
        
        /**
         * 是否存离线
         */
        private Boolean isOffline;
        
        /**
         * 目标系统类型
         */
        private List<String> targetOs;

        public Long getBroadcastId() {
            return broadcastId;
        }

        public void setBroadcastId(Long broadcastId) {
            this.broadcastId = broadcastId;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }

        public Boolean getIsOffline() {
            return isOffline;
        }

        public void setIsOffline(Boolean isOffline) {
            this.isOffline = isOffline;
        }

        public List<String> getTargetOs() {
            return targetOs;
        }

        public void setTargetOs(List<String> targetOs) {
            this.targetOs = targetOs;
        }
    }
}
