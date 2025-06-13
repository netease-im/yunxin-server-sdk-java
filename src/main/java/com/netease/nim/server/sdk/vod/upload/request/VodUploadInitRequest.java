package com.netease.nim.server.sdk.vod.upload.request;

/**
 * Created by caojiajun on 2025/6/12
 */
public class VodUploadInitRequest {

    private String originFileName;
    private String userFileName;
    private Integer typeId;
    private Integer presetId;
    private String uploadCallbackUrl;
    private String callbackUrl;
    private String description;
    private Integer watermarkId;
    private String userDefInfo;
    private Integer transOffset;
    private Integer transDuration;

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getPresetId() {
        return presetId;
    }

    public void setPresetId(Integer presetId) {
        this.presetId = presetId;
    }

    public String getUploadCallbackUrl() {
        return uploadCallbackUrl;
    }

    public void setUploadCallbackUrl(String uploadCallbackUrl) {
        this.uploadCallbackUrl = uploadCallbackUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWatermarkId() {
        return watermarkId;
    }

    public void setWatermarkId(Integer watermarkId) {
        this.watermarkId = watermarkId;
    }

    public String getUserDefInfo() {
        return userDefInfo;
    }

    public void setUserDefInfo(String userDefInfo) {
        this.userDefInfo = userDefInfo;
    }

    public Integer getTransOffset() {
        return transOffset;
    }

    public void setTransOffset(Integer transOffset) {
        this.transOffset = transOffset;
    }

    public Integer getTransDuration() {
        return transDuration;
    }

    public void setTransDuration(Integer transDuration) {
        this.transDuration = transDuration;
    }
}
