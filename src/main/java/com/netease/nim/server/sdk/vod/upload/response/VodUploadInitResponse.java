package com.netease.nim.server.sdk.vod.upload.response;

/**
 * Created by caojiajun on 2025/6/12
 */
public class VodUploadInitResponse {
    private String xNosToken;
    private String bucket;
    private String object;

    public String getxNosToken() {
        return xNosToken;
    }

    public void setxNosToken(String xNosToken) {
        this.xNosToken = xNosToken;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
