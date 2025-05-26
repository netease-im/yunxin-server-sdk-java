package com.netease.nim.im.server.sdk.v1.chatroom.request;


import com.netease.nim.im.server.sdk.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class SetMemberRoleRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("operator")
    private String operator;

    @YunxinParam("target")
    private String target;

    @YunxinParam("opt")
    private Integer opt;

    @YunxinParam("optvalue")
    private Boolean optValue;

    @YunxinParam("notifyExt")
    private String notifyExt;

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getOpt() {
        return opt;
    }

    public void setOpt(Integer opt) {
        this.opt = opt;
    }

    public Boolean getOptValue() {
        return optValue;
    }

    public void setOptValue(Boolean optValue) {
        this.optValue = optValue;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
    }
}
