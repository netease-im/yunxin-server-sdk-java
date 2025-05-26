package com.netease.nim.im.server.sdk.v2.broadcast.response;

import com.alibaba.fastjson2.annotation.JSONField;
import java.util.List;

/**
 * Response for querying broadcast notification
 */
public class QueryBroadcastNotificationResponseV2 {

    /**
     * Broadcast message ID
     */
    @JSONField(name = "broadcast_id")
    private String broadcastId;

    /**
     * Sender's account ID
     */
    @JSONField(name = "from_account_id")
    private String fromAccountId;

    /**
     * Broadcast message content
     */
    @JSONField(name = "content")
    private String content;

    /**
     * Whether the broadcast message is stored offline
     */
    @JSONField(name = "offline_enabled")
    private Boolean offlineEnabled;

    /**
     * Target operating systems
     */
    @JSONField(name = "target_os")
    private List<String> targetOs;

    /**
     * Creation timestamp of the broadcast message
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * Expiration timestamp of the broadcast message
     */
    @JSONField(name = "expire_time")
    private Long expireTime;

    /**
     * Get broadcast message ID
     *
     * @return Broadcast message ID
     */
    public String getBroadcastId() {
        return broadcastId;
    }

    /**
     * Set broadcast message ID
     *
     * @param broadcastId Broadcast message ID
     */
    public void setBroadcastId(String broadcastId) {
        this.broadcastId = broadcastId;
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
     * Get offline storage status
     *
     * @return Whether the broadcast message is stored offline
     */
    public Boolean getOfflineEnabled() {
        return offlineEnabled;
    }

    /**
     * Set offline storage status
     *
     * @param offlineEnabled Whether the broadcast message is stored offline
     */
    public void setOfflineEnabled(Boolean offlineEnabled) {
        this.offlineEnabled = offlineEnabled;
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

    /**
     * Get creation timestamp
     *
     * @return Creation timestamp of the broadcast message
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * Set creation timestamp
     *
     * @param createTime Creation timestamp of the broadcast message
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * Get expiration timestamp
     *
     * @return Expiration timestamp of the broadcast message
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * Set expiration timestamp
     *
     * @param expireTime Expiration timestamp of the broadcast message
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
} 