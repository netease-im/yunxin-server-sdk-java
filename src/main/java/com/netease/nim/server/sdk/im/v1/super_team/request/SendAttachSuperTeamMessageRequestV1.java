package com.netease.nim.server.sdk.im.v1.super_team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

import java.util.List;

public class SendAttachSuperTeamMessageRequestV1 {

    @YunxinParam("from")
    private String from;

    @YunxinParam("to")
    private Long to;

    @YunxinParam("attach")
    private String attach;

    @YunxinParam("pushContent")
    private String pushContent;

    @YunxinParam("pushPayload")
    private String pushPayload;

    @YunxinParam("sound")
    private String sound;

    @YunxinParam("save")
    private Integer save;

    @YunxinParam("option")
    private String option;

    @YunxinParam("isForcePush")
    private Boolean isForcePush;

    @YunxinParam("forcePushContent")
    private String forcePushContent;

    @YunxinParam("forcePushAll")
    private Boolean forcePushAll;

    @YunxinParam("forcePushList")
    private List<String> forcePushList;

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

    public Boolean getForcePush() {
        return isForcePush;
    }

    public void setForcePush(Boolean forcePush) {
        isForcePush = forcePush;
    }

    public String getForcePushContent() {
        return forcePushContent;
    }

    public void setForcePushContent(String forcePushContent) {
        this.forcePushContent = forcePushContent;
    }

    public Boolean getForcePushAll() {
        return forcePushAll;
    }

    public void setForcePushAll(Boolean forcePushAll) {
        this.forcePushAll = forcePushAll;
    }

    public List<String> getForcePushList() {
        return forcePushList;
    }

    public void setForcePushList(List<String> forcePushList) {
        this.forcePushList = forcePushList;
    }
}