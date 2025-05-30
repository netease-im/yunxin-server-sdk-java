package com.netease.nim.im.server.sdk.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by hekaijie on 2024/12/24
 */
public class TagTemporaryMuteResponseV1 {
    @JSONField(name = "roomid")
    private Long roomId;
    private String tag;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
