package com.netease.nim.server.sdk.im.v1.super_team.response;

public class SendSuperTeamMessageResponseV1 {
    /**
     * 消息 ID
     */
    private Long msgid;

    /**
     * 发送时间戳
     */
    private Long timetag;

    /**
     * 是否通过反垃圾
     */
    private Boolean antispam;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

    public Boolean getAntispam() {
        return antispam;
    }

    public void setAntispam(Boolean antispam) {
        this.antispam = antispam;
    }
}
