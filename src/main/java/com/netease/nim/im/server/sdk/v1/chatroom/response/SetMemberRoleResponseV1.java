package com.netease.nim.im.server.sdk.v1.chatroom.response;


import com.alibaba.fastjson2.annotation.JSONField;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class SetMemberRoleResponseV1 {

    @JSONField(name = "roomid")
    private Long roomId;

    private Integer level;

    private String accid;

    private String type;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
