package com.netease.nim.server.sdk.live.manage.response;


/**
 * Created by caojiajun on 2025/6/12
 */
public class LiveCreateChannelResponse {
    private String cid;
    private Long ctime;
    private String name;
    private String pushUrl;
    private String httpPullUrl;
    private String hlsPullUrl;
    private String rtmpPullUrl;
    private String rtsPullUrl;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }

    public String getHttpPullUrl() {
        return httpPullUrl;
    }

    public void setHttpPullUrl(String httpPullUrl) {
        this.httpPullUrl = httpPullUrl;
    }

    public String getHlsPullUrl() {
        return hlsPullUrl;
    }

    public void setHlsPullUrl(String hlsPullUrl) {
        this.hlsPullUrl = hlsPullUrl;
    }

    public String getRtmpPullUrl() {
        return rtmpPullUrl;
    }

    public void setRtmpPullUrl(String rtmpPullUrl) {
        this.rtmpPullUrl = rtmpPullUrl;
    }

    public String getRtsPullUrl() {
        return rtsPullUrl;
    }

    public void setRtsPullUrl(String rtsPullUrl) {
        this.rtsPullUrl = rtsPullUrl;
    }
}
