package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class UpdateChatroomDelayClosePolicyRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("delayClosePolicy")
    private Integer delayClosePolicy;

    @YunxinParam("delaySeconds")
    private Long delaySeconds;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getDelayClosePolicy() {
        return delayClosePolicy;
    }

    public void setDelayClosePolicy(Integer delayClosePolicy) {
        this.delayClosePolicy = delayClosePolicy;
    }

    public Long getDelaySeconds() {
        return delaySeconds;
    }

    public void setDelaySeconds(Long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }
}
