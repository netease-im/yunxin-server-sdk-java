package com.netease.nim.server.sdk.im.v2.system_push.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for listing push notifications with pagination
 */
public class ListPushNotificationsResponseV2 {
    
    @JSONField(name = "has_more")
    private Boolean hasMore;
    
    @JSONField(name = "next_token")
    private String nextToken;
    
    @JSONField(name = "items")
    private List<PushNotificationItem> items;
    
    public ListPushNotificationsResponseV2() {
    }
    
    public Boolean getHasMore() {
        return hasMore;
    }
    
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    public String getNextToken() {
        return nextToken;
    }
    
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    
    public List<PushNotificationItem> getItems() {
        return items;
    }
    
    public void setItems(List<PushNotificationItem> items) {
        this.items = items;
    }
    
    public static class PushNotificationItem {
        
        @JSONField(name = "push_id")
        private Long pushId;
        
        @JSONField(name = "sender_account_id")
        private String senderAccountId;
        
        @JSONField(name = "content")
        private String content;
        
        @JSONField(name = "target_type")
        private Integer targetType;
        
        @JSONField(name = "target_os")
        private List<String> targetOs;
        
        @JSONField(name = "roam_enabled")
        private Boolean roamEnabled;
        
        @JSONField(name = "roam_expire_time")
        private Long roamExpireTime;
        
        @JSONField(name = "create_time")
        private Long createTime;
        
        @JSONField(name = "push_config")
        private PushConfig pushConfig;
        
        public PushNotificationItem() {
        }
        
        public Long getPushId() {
            return pushId;
        }
        
        public void setPushId(Long pushId) {
            this.pushId = pushId;
        }
        
        public String getSenderAccountId() {
            return senderAccountId;
        }
        
        public void setSenderAccountId(String senderAccountId) {
            this.senderAccountId = senderAccountId;
        }
        
        public String getContent() {
            return content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
        
        public Integer getTargetType() {
            return targetType;
        }
        
        public void setTargetType(Integer targetType) {
            this.targetType = targetType;
        }
        
        public List<String> getTargetOs() {
            return targetOs;
        }
        
        public void setTargetOs(List<String> targetOs) {
            this.targetOs = targetOs;
        }
        
        public Boolean getRoamEnabled() {
            return roamEnabled;
        }
        
        public void setRoamEnabled(Boolean roamEnabled) {
            this.roamEnabled = roamEnabled;
        }
        
        public Long getRoamExpireTime() {
            return roamExpireTime;
        }
        
        public void setRoamExpireTime(Long roamExpireTime) {
            this.roamExpireTime = roamExpireTime;
        }
        
        public Long getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
        
        public PushConfig getPushConfig() {
            return pushConfig;
        }
        
        public void setPushConfig(PushConfig pushConfig) {
            this.pushConfig = pushConfig;
        }
    }
    
    public static class PushConfig {
        
        @JSONField(name = "push_nick_enabled")
        private Boolean pushNickEnabled;
        
        @JSONField(name = "push_badge_enabled")
        private Boolean pushBadgeEnabled;
        
        @JSONField(name = "push_content")
        private String pushContent;
        
        @JSONField(name = "push_payload")
        private String pushPayload;
        
        public PushConfig() {
        }
        
        public Boolean getPushNickEnabled() {
            return pushNickEnabled;
        }
        
        public void setPushNickEnabled(Boolean pushNickEnabled) {
            this.pushNickEnabled = pushNickEnabled;
        }
        
        public Boolean getPushBadgeEnabled() {
            return pushBadgeEnabled;
        }
        
        public void setPushBadgeEnabled(Boolean pushBadgeEnabled) {
            this.pushBadgeEnabled = pushBadgeEnabled;
        }
        
        public String getPushContent() {
            return pushContent;
        }
        
        public void setPushContent(String pushContent) {
            this.pushContent = pushContent;
        }
        
        public String getPushPayload() {
            return pushPayload;
        }
        
        public void setPushPayload(String pushPayload) {
            this.pushPayload = pushPayload;
        }
    }
}

