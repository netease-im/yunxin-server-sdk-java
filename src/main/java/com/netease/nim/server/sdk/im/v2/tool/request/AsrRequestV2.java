package com.netease.nim.server.sdk.im.v2.tool.request;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * V2 speech-to-text request
 */
public class AsrRequestV2 {
    /**
     * Operator account id
     */
    @JSONField(name = "operator_account_id")
    private String operatorAccountId;
    /**
     * Audio format, such as: wav, opus, mp3, aac
     */
    @JSONField(name = "format")
    private String format;
    /**
     * Audio url
     */
    @JSONField(name = "url")
    private String url;
    /**
     * Sample rate
     */
    @JSONField(name = "sample_rate")
    private Integer sampleRate;
    /**
     * Audio duration, ms
     */
    @JSONField(name = "duration")
    private Long duration;

    public AsrRequestV2() {
    }

    public AsrRequestV2(String operatorAccountId, String format, String url) {
        this.operatorAccountId = operatorAccountId;
        this.format = format;
        this.url = url;
    }

    public String getOperatorAccountId() {
        return operatorAccountId;
    }

    public void setOperatorAccountId(String operatorAccountId) {
        this.operatorAccountId = operatorAccountId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
