package com.netease.nim.server.sdk.im.v2.system_push.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for sending push notifications to all users
 * 
 * API: POST https://open.yunxinapi.com/im/v2/push_notification
 */
public class SendPushNotificationRequestV2 {
    
    @JSONField(name = "content")
    private String content;
    
    @JSONField(name = "push_config")
    private PushConfig pushConfig;
    
    @JSONField(name = "sender_account_id")
    private String senderAccountId;
    
    @JSONField(name = "target_type")
    private Integer targetType;
    
    @JSONField(name = "target_os")
    private List<String> targetOs;
    
    @JSONField(name = "roam_enabled")
    private Boolean roamEnabled;
    
    @JSONField(name = "roam_expire_after")
    private Long roamExpireAfter;
    
    public SendPushNotificationRequestV2() {
    }
    
    public SendPushNotificationRequestV2(Integer targetType) {
        this.targetType = targetType;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public PushConfig getPushConfig() {
        return pushConfig;
    }
    
    public void setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
    }
    
    public String getSenderAccountId() {
        return senderAccountId;
    }
    
    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
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
    
    public Long getRoamExpireAfter() {
        return roamExpireAfter;
    }
    
    public void setRoamExpireAfter(Long roamExpireAfter) {
        this.roamExpireAfter = roamExpireAfter;
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

