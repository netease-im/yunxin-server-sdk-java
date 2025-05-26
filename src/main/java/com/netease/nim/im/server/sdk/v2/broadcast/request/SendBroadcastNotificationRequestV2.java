package com.netease.nim.im.server.sdk.v2.broadcast.request;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Request for sending broadcast notifications to all users in the app
 */
public class SendBroadcastNotificationRequestV2 {

    /**
     * Required. Broadcast message content, max length 4096 characters
     */
    @JSONField(name = "content")
    private String content;

    /**
     * Optional. Sender's account ID
     */
    @JSONField(name = "from_account_id")
    private String fromAccountId;

    /**
     * Optional. Whether to store the message offline. Default is false
     */
    @JSONField(name = "offline_enabled")
    private Boolean offlineEnabled;

    /**
     * Optional. Time-to-live for offline messages in hours. Default is 168 (7 days)
     * Only effective when offlineEnabled is true
     */
    @JSONField(name = "ttl")
    private Integer ttl;

    /**
     * Optional. Target operating systems to receive the broadcast
     * e.g. ["ios", "aos", "pc", "web", "mac"]
     */
    @JSONField(name = "target_os")
    private List<String> targetOs;

    /**
     * Constructor with required parameters
     *
     * @param content Broadcast message content
     */
    public SendBroadcastNotificationRequestV2(String content) {
        this.content = content;
    }

    /**
     * Get broadcast message content
     *
     * @return Content of the broadcast message
     */
    public String getContent() {
        return content;
    }

    /**
     * Set broadcast message content
     *
     * @param content Content of the broadcast message
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get sender's account ID
     *
     * @return Sender's account ID
     */
    public String getFromAccountId() {
        return fromAccountId;
    }

    /**
     * Set sender's account ID
     *
     * @param fromAccountId Sender's account ID
     */
    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    /**
     * Get offline storage status
     *
     * @return Whether broadcast messages are stored offline
     */
    public Boolean getOfflineEnabled() {
        return offlineEnabled;
    }

    /**
     * Set offline storage status
     *
     * @param offlineEnabled Whether broadcast messages should be stored offline
     */
    public void setOfflineEnabled(Boolean offlineEnabled) {
        this.offlineEnabled = offlineEnabled;
    }

    /**
     * Get time-to-live for offline messages
     *
     * @return TTL in hours
     */
    public Integer getTtl() {
        return ttl;
    }

    /**
     * Set time-to-live for offline messages
     *
     * @param ttl TTL in hours
     */
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    /**
     * Get target operating systems
     *
     * @return List of target operating systems
     */
    public List<String> getTargetOs() {
        return targetOs;
    }

    /**
     * Set target operating systems
     *
     * @param targetOs List of target operating systems
     */
    public void setTargetOs(List<String> targetOs) {
        this.targetOs = targetOs;
    }
} 