package com.netease.nim.im.server.sdk.v1.super_team.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class SendAttachSuperMessageRequestV1 {

    /**
     * 发送者账号，accid，最大长度 32 位字符
     */
    @YunxinParam("from")
    private String from;

    /**
     * 接收系统通知的超大群 ID（即 tid），最大长度 64 位长整型
     */
    @YunxinParam("to")
    private Long to;

    /**
     * 自定义系统通知的具体内容，建议 JSON 格式，最大长度 4096 位字符
     */
    @YunxinParam("attach")
    private String attach;

    /**
     * iOS 推送内容，最大长度 500 位字符
     */
    @YunxinParam("pushContent")
    private String pushContent;

    /**
     * iOS 推送对应的 pushPayload，必须 JSON 格式，最大长度 2048 位字符
     */
    @YunxinParam("pushPayload")
    private String pushPayload;

    /**
     * 如果有指定推送，此属性指定为客户端本地的声音文件名，最大长度 30 位字符
     */
    @YunxinParam("sound")
    private String sound;

    /**
     * 1，只发在线系统通知；2，会存离线，默认会存离线
     */
    @YunxinParam("save")
    private Integer save;

    /**
     * 发通知时特殊指定的行为选项，JSON 格式
     */
    @YunxinParam("option")
    private String option;

    /**
     * 发自定义系统通知时，是否强制推送，默认 false
     */
    @YunxinParam("isForcePush")
    private String isForcePush;

    /**
     * 发自定义系统通知时，强制推送的文案，最大长度 500 位字符
     */
    @YunxinParam("forcePushContent")
    private String forcePushContent;

    /**
     * 发群自定义系统通知时，强推列表是否为群里除发送者外的所有有效成员，默认 false
     */
    @YunxinParam("forcePushAll")
    private String forcePushAll;

    /**
     * 发群自定义系统通知时的强推列表，格式为 JSONArray
     */
    @YunxinParam("forcePushList")
    private String forcePushList;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
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

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Integer getSave() {
        return save;
    }

    public void setSave(Integer save) {
        this.save = save;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getIsForcePush() {
        return isForcePush;
    }

    public void setIsForcePush(String isForcePush) {
        this.isForcePush = isForcePush;
    }

    public String getForcePushContent() {
        return forcePushContent;
    }

    public void setForcePushContent(String forcePushContent) {
        this.forcePushContent = forcePushContent;
    }

    public String getForcePushAll() {
        return forcePushAll;
    }

    public void setForcePushAll(String forcePushAll) {
        this.forcePushAll = forcePushAll;
    }

    public String getForcePushList() {
        return forcePushList;
    }

    public void setForcePushList(String forcePushList) {
        this.forcePushList = forcePushList;
    }
}