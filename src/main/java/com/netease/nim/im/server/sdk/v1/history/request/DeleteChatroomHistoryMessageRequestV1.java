package com.netease.nim.im.server.sdk.v1.history.request;

import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

public class DeleteChatroomHistoryMessageRequestV1 {

    /**
     * 聊天室 ID
     */
    @YunxinParam("roomid")
    private Long roomid;

    /**
     * 消息发送者的账号 ID（`accid`）
     */
    @YunxinParam("fromAcc")
    private String fromAcc;

    /**
     * 消息的时间戳，单位毫秒
     */
    @YunxinParam("msgTimetag")
    private Long msgTimetag;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }

    public Long getMsgTimetag() {
        return msgTimetag;
    }

    public void setMsgTimetag(Long msgTimetag) {
        this.msgTimetag = msgTimetag;
    }

}
