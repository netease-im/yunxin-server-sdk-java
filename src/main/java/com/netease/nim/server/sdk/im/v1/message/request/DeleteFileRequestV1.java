package com.netease.nim.server.sdk.im.v1.message.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class DeleteFileRequestV1 {

    /**
     * 开始时间(毫秒级)
     */
    @YunxinParam("startTime")
    private Long startTime;

    /**
     * 结束时间(毫秒级)
     */
    @YunxinParam("endTime")
    private Long endTime;

    /**
     * 被清理的文件类型
     */
    @YunxinParam("contentType")
    private String contentType;

    /**
     * 被清理文件的应用场景
     */
    @YunxinParam("tag")
    private String tag;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
