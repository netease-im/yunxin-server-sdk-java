package com.netease.nim.server.sdk.im.v1.chatroom.request;

import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

public class TemporaryMuteRequestV1 {

    @YunxinParam("roomid")
    private Long roomid;

    /**
     * 操作者accid,必须是管理员或创建者
     */
    @YunxinParam("operator")
    private String operator;

    /**
     * 被禁言的目标账号accid
     */
    @YunxinParam("target")
    private String target;

    /**
     * 0:解除禁言;>0设置禁言的秒数，不能超过2592000秒(30天)
     */
    @YunxinParam("muteDuration")
    private Long muteDuration;

    /**
     * 操作完成后是否发送通知消息，true：发送，false：不发送，默认 true
     */
    @YunxinParam("needNotify")
    private Boolean needNotify;

    /**
     * 通知消息的扩展字段，长度限制 2048 字符
     */
    @YunxinParam("notifyExt")
    private String notifyExt;

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
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

    public Long getMuteDuration() {
        return muteDuration;
    }

    public void setMuteDuration(Long muteDuration) {
        this.muteDuration = muteDuration;
    }

    public Boolean getNeedNotify() {
        return needNotify;
    }

    public void setNeedNotify(Boolean needNotify) {
        this.needNotify = needNotify;
    }

    public String getNotifyExt() {
        return notifyExt;
    }

    public void setNotifyExt(String notifyExt) {
        this.notifyExt = notifyExt;
    }
}