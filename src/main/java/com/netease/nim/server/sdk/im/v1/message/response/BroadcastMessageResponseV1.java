package com.netease.nim.server.sdk.im.v1.message.response;

import java.util.List;

public class BroadcastMessageResponseV1 {

    /**
     * 广播消息的 ID
     */
    private Long broadcastId;

    /**
     * 发送者的云信 IM 账号
     */
    private String from;

    /**
     * 广播消息内容
     */
    private String body;

    /**
     * 目标客户端列表
     */
    private List<String> targetOs;

    /**
     * 广播消息是否存离线
     */
    private Boolean isOffline;

    /**
     * 广播消息创建时间
     */
    private Long createTime;

    /**
     * 广播消息过期时间
     */
    private Long expireTime;

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getTargetOs() {
        return targetOs;
    }

    public void setTargetOs(List<String> targetOs) {
        this.targetOs = targetOs;
    }

    public Boolean getOffline() {
        return isOffline;
    }

    public void setOffline(Boolean offline) {
        isOffline = offline;
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

}
