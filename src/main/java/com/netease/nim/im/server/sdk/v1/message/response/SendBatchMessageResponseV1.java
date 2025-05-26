package com.netease.nim.im.server.sdk.v1.message.response;

public class SendBatchMessageResponseV1 {

    /**
     * toAccids 列表中存在的未注册用户
     */
    private String unregister;

    /**
     * 消息发送的时间戳
     */
    private Long timetag;

    /**
     * 发送给每个 accid 的消息 ID 列表
     */
    private String msgids;

    public String getUnregister() {
        return unregister;
    }

    public void setUnregister(String unregister) {
        this.unregister = unregister;
    }

    public Long getTimetag() {
        return timetag;
    }

    public void setTimetag(Long timetag) {
        this.timetag = timetag;
    }

    public String getMsgids() {
        return msgids;
    }

    public void setMsgids(String msgids) {
        this.msgids = msgids;
    }

}
