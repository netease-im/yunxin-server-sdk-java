package com.netease.nim.server.sdk.im.v1.chatroom.request;


import com.netease.nim.server.sdk.im.v1.annotation.YunxinParam;

/**
 * Created by hekaijie  on 2024/12/24
 */
public class QueryMembersByRolesRequestV1 {

    @YunxinParam("roomid")
    private Long roomId;

    @YunxinParam("roles")
    private String roles;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
