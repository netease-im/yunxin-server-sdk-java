package com.netease.nim.server.sdk.im.v1.super_team.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class RecallSuperTeamMessageRequestV1 {

    @YunxinParam("deleteMsgid")
    private Long deleteMsgid;

    @YunxinParam("timetag")
    private Long timetag;

    @YunxinParam("from")
    private String from;

    @YunxinParam("to")
    private Long to;

    @YunxinParam("msg")
    private String msg;

    @YunxinParam("ignoreTime")
    private Integer ignoreTime;

    @YunxinParam("pushContent")
    private String pushContent;

    @YunxinParam("pushPayload")
    private String pushPayload;

    public Long getDeleteMsgid() {
        return deleteMsgid;
    }

    public void setDeleteMsgid(Long deleteMsgid) {
        this.deleteMsgid = deleteMsgid;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getIgnoreTime() {
        return ignoreTime;
    }

    public void setIgnoreTime(Integer ignoreTime) {
        this.ignoreTime = ignoreTime;
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
}