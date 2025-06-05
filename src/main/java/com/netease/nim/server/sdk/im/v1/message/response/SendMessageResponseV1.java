package com.netease.nim.server.sdk.im.v1.message.response;

public class SendMessageResponseV1 {

    /**
     * 消息 ID
     */
    private Long msgid;

    /**
     * 消息是否被反垃圾（内容审核）拦截，如未被拦截则值为 false
     */
    private Boolean antispam;

    /**
     * 消息发送的时间戳
     */
    private Long timetag;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public Boolean getAntispam() {
        return antispam;
    }

    public void setAntispam(Boolean antispam) {
        this.antispam = antispam;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

}
