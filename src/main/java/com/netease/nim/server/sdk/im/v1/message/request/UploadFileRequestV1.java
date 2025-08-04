package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class UploadFileRequestV1 {

    /**
     * 字符流 base64 串（Base64.encode(bytes)），最大 15M 的字符流
     */
    @YunxinParam("content")
    private String content;

    /**
     * 上传文件类型。最多 128 字符，超限视为 null
     */
    @YunxinParam("type")
    private String type;

    /**
     * 返回的 URL 是否需要为 HTTPS 的 URL，默认 false
     */
    @YunxinParam("ishttps")
    private Boolean ishttps;

    /**
     * 文件过期时长，单位：秒，必须大于或等于 86400
     */
    @YunxinParam("expireSec")
    private Integer expireSec;

    /**
     * 文件的应用场景，最多 32 个字符
     */
    @YunxinParam("tag")
    private String tag;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIshttps() {
        return ishttps;
    }

    public void setIshttps(Boolean ishttps) {
        this.ishttps = ishttps;
    }

    public Integer getExpireSec() {
        return expireSec;
    }

    public void setExpireSec(Integer expireSec) {
        this.expireSec = expireSec;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
