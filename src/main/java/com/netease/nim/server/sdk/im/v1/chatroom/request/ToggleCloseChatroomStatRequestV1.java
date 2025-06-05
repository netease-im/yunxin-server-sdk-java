package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class ToggleCloseChatroomStatRequestV1 {
    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("operator")
    private String operator;

    @YunxinParam("valid")
    private Boolean valid;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
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
